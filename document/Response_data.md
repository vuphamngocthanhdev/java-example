## Response data

### Tại sao phải response ?

 - Đồng nhất giữa các nền tảng: Mobile và web có thể sử dụng chung một API,nên cần định dạng dữ liệu đồng nhất. Điều này giúp dễ dàng duy trì và phát triển ứng dụng, giảm thiểu lỗi và sự phức tạp trong việc xử lý dữ liệu giữa các nền tảng khác nhau.

- Hiệu suất: Mobile thường có băng thông hạn chế, do đó việc định dạng dữ liệu cần nhẹ, tối ưu hóa dung lượng truyền tải để giảm tải cho mạng và tiết kiệm pin. JSON là định dạng phổ biến vì nó nhẹ và dễ parse trên cả hai nền tảng.

- Khả năng mở rộng và tái sử dụng: Định dạng phản hồi cần linh hoạt để có thể mở rộng và đáp ứng các yêu cầu của cả web và mobile. Ví dụ, có thể thêm các trường hoặc tùy chỉnh mà không làm gián đoạn ứng dụng.

- Tương thích với UI: Mobile và web có thể có các yêu cầu UI khác nhau, nhưng cả hai cần nhận được dữ liệu dưới dạng có cấu trúc rõ ràng, dễ dàng để xử lý và hiển thị. Đảm bảo dữ liệu định dạng theo kiểu mà cả hai nền tảng có thể render nhanh chóng và chính xác.

- Đáp ứng các tính năng đa thiết bị: Mobile và web có thể có các tính năng khác nhau, nhưng đều cần dữ liệu có cấu trúc nhất quán để dễ dàng phát triển và duy trì.

- Tùy theo format của công ty mà chúng ta sẽ response theo yêu cầu.Ở phần này dev tự thiết kế, có thể đọc code mẫu. (không có phần hướng dẫn code)