DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Instructor;


-- Tạo bảng Instructor
CREATE TABLE IF NOT EXISTS Instructor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    board TEXT NOT NULL
);

-- Tạo bảng Post với khóa ngoại tham chiếu đến bảng Instructor
CREATE TABLE IF NOT EXISTS Post (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    instructor_id INTEGER NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES Instructor(id)
);

-- Thêm một số dữ liệu mẫu vào bảng Instructor
INSERT INTO Instructor (id, title, board) VALUES (1, 'Kaito1', '천제 게시판');
INSERT INTO Instructor (id, title, board) VALUES (2, 'Kaito2', '자유 게시판');
INSERT INTO Instructor (id, title, board) VALUES (3, 'Kaito3', '개발 게시판');
INSERT INTO Instructor (id, title, board) VALUES (4, 'Kaito4', '일상 게시판');
INSERT INTO Instructor (id, title, board) VALUES (5, 'Kaito5', '사건사고 게시판');