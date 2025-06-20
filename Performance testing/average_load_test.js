import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend } from 'k6/metrics';

// สร้าง Trends เพื่อเก็บข้อมูลสถิติ
let myTrend = new Trend('my_trend');

export const options = {
  stages: [
    { duration: "3m", target: 100 }, 
    { duration: "10m", target: 100 }, 
    { duration: "3m", target: 0 }, 
  ]
};

export default function () {
  const params = {
    timeout: '360s'
  }
  
  const res = http.get('http://45.144.164.182:8080/');
  check(res, { 'status was 200': (r) => r.status == 200 });

  // เพิ่มข้อมูลเข้า Trends
  myTrend.add(res.timings.duration);

  sleep(1);
}

