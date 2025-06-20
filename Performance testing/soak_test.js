import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend } from 'k6/metrics';

// สร้าง Trends เพื่อเก็บข้อมูลสถิติ
let myTrend = new Trend('my_trend');

export const options = {
  stages: [
    { duration: '2m', target: 100 }, //ramp up to 100 in 2 minute
    { duration: '1h', target: 100 }, //stay at 100 fors 1 hours
    { duration: '2m', target: 0 }, // scale down to 0  in 2 minute

  ],
};

export default function () {
  const params = {
    timeout: '360s'   // set timeout for request
  }
  const res = http.get('http://45.144.164.182:8080/', params);
  check(res, { 'status was 200': (r) => r.status == 200 });

  // เพิ่มข้อมูลเข้า Trends
  myTrend.add(res.timings.duration);

  sleep(1);
}

export function handleSummary(data) {
  // แปลงข้อมูล Trends เป็น JSON
  const jsonOutput = JSON.stringify(myTrend);

  // บันทึก JSON ลงในไฟล์
  const fileName = 'soak_test180.json';
  const file = open(fileName, 'w');
  file.write(jsonOutput);
  file.close();

  // k6 run script.js --out json=soak_test2.json
  // cd '.\OneDrive\Desktop\SQA_Project _2\'
}