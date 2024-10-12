
# Giải thích các Annotation trong Spring Boot

### 1. `@RestController`
- **Mô tả:** Annotation này kết hợp giữa `@Controller` và `@ResponseBody`, được sử dụng để chỉ định rằng lớp này sẽ xử lý các yêu cầu HTTP và trả về dữ liệu trực tiếp (thường là JSON hoặc XML) thay vì trả về một view.
- **Sử dụng:** Thích hợp cho các API RESTful.

### 2. `@RequestMapping`
- **Mô tả:** Annotation này được sử dụng để ánh xạ một URL với một phương thức trong controller. Nó có thể được áp dụng cho lớp hoặc phương thức.
- **Sử dụng:** Có thể chỉ định phương thức HTTP (GET, POST, PUT, DELETE) và các thông tin khác như tiêu đề và tham số truy vấn.

### 3. `@RequestBody`
- **Mô tả:** Annotation này được sử dụng để ánh xạ nội dung của yêu cầu HTTP (thường là JSON) vào một đối tượng Java.
- **Sử dụng:** Thích hợp cho các yêu cầu POST hoặc PUT, nơi bạn muốn gửi dữ liệu từ client đến server.

### 4. `@RequestParam`
- **Mô tả:** Annotation này được sử dụng để lấy các tham số truy vấn từ URL.
- **Sử dụng:** Thường được dùng cho các yêu cầu GET để lấy các giá trị từ URL, ví dụ: `?name=John`.

### 5. `@PathVariable`
- **Mô tả:** Annotation này được sử dụng để lấy các giá trị từ phần đường dẫn của URL.
- **Sử dụng:** Thích hợp cho các URL có cấu trúc như `/users/{id}`, nơi `{id}` là một phần biến trong đường dẫn.

### 6. `@GetMapping`
- **Mô tả:** Annotation này là một cách rút gọn cho `@RequestMapping(method = RequestMethod.GET)`, dùng để chỉ định rằng phương thức sẽ xử lý các yêu cầu GET.
- **Sử dụng:** Thích hợp cho các yêu cầu lấy dữ liệu từ server.

### 7. `@PostMapping`
- **Mô tả:** Annotation này là một cách rút gọn cho `@RequestMapping(method = RequestMethod.POST)`, dùng để chỉ định rằng phương thức sẽ xử lý các yêu cầu POST.
- **Sử dụng:** Thích hợp cho các yêu cầu gửi dữ liệu đến server, ví dụ như tạo mới một bản ghi.

### 8. `@PutMapping`
- **Mô tả:** Annotation này là một cách rút gọn cho `@RequestMapping(method = RequestMethod.PUT)`, dùng để chỉ định rằng phương thức sẽ xử lý các yêu cầu PUT.
- **Sử dụng:** Thích hợp cho các yêu cầu cập nhật dữ liệu trên server.

### 9. `@DeleteMapping`
- **Mô tả:** Annotation này là một cách rút gọn cho `@RequestMapping(method = RequestMethod.DELETE)`, dùng để chỉ định rằng phương thức sẽ xử lý các yêu cầu DELETE.
- **Sử dụng:** Thích hợp cho các yêu cầu xóa dữ liệu trên server.

### 10. `@PatchMapping`
- **Mô tả:** Annotation này là một cách rút gọn cho `@RequestMapping(method = RequestMethod.PATCH)`, dùng để chỉ định rằng phương thức sẽ xử lý các yêu cầu PATCH.
- **Sử dụng:** Thích hợp cho các yêu cầu cập nhật một phần của tài nguyên.

***
*pom.xml*
```xml
<dependencies>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.6.0</version>
    </dependency>
</dependencies>
```