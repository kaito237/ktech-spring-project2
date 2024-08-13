DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Instructor;


-- Tạo bảng Instructor
CREATE TABLE IF NOT EXISTS Instructor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    title TEXT NOT NULL
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
INSERT INTO Instructor (name,title) VALUES ('Instructor1', 'password123');
INSERT INTO Instructor (name, title) VALUES ('Instructor2', 'password456');
INSERT INTO Instructor (name, title) VALUES ('Instructor3', 'password789');
INSERT INTO Instructor (name, title) VALUES ('Instructor4', 'password321');
INSERT INTO Instructor (name, title) VALUES ('Instructor5', 'password654');

