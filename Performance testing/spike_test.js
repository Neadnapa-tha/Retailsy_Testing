import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend } from 'k6/metrics';

// สร้าง Trends เพื่อเก็บข้อมูลสถิติ
let myTrend = new Trend('my_trend');

export const options = {
  stages: [
    { duration: '10s', target: 50 },  // เพิ่ม User จาก 1 ไป 50 คนภายในเวลา 50 วินาที
    { duration: '2m', target: 500 }, // เพิ่ม User จาก 50 ไป 500 ภายในเวลา 2 นาที
    { duration: '1m', target: 100 }, // ลด User จาก 500 เหลือ 100 ภายในเวลา 1 นาที
    { duration: '30s', target: 10 }, // ลด User จาก 100 เหลือ 10 ภายในเวลา 30 วินาที
    { duration: '10s', target: 0 }, // ลด User ให้เหลือ 0 ภายในเวลา 10 วินาที
  ],
};

export default function () {
  const res = http.get('http://45.144.164.182:8080/');
  check(res, { 'status was 200': (r) => r.status == 200 });

  // เพิ่มข้อมูลเข้า Trends
  myTrend.add(res.timings.duration);

  sleep(1);
}

// export function handleSummary(data) {
//   // แปลงข้อมูล Trends เป็น JSON
//   const jsonOutput = JSON.stringify(myTrend);

//   // บันทึก JSON ลงในไฟล์
//   const fileName = 'test2.json';
//   const file = open(fileName, 'w');
//   file.write(jsonOutput);
//   file.close();
// }
