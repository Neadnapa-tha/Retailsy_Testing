import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend } from 'k6/metrics';

// สร้าง Trends เพื่อเก็บข้อมูลสถิติ
let myTrend = new Trend('my_trend');

export const options = {
  stages: [
    { duration: '2m', target: 100 },  // normal load
    { duration: '3m', target: 200 },  
    { duration: '5m', target: 200 },  // around the breaking point
    { duration: '10m', target: 200 }, 
    { duration: '2m', target: 200 },
    { duration: '5m', target: 0 },    // scale down. Recovery stage.
  ],
};

export default function () {
  const res = http.get('http://45.144.164.182:8080/');
  check(res, { 'status was 200': (r) => r.status == 200 });

  // เพิ่มข้อมูลเข้า Trends
  myTrend.add(res.timings.duration);

  sleep(1);
}