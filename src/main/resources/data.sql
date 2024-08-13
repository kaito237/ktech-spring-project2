DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Instructor;

-- Tạo bảng Instructor
CREATE TABLE IF NOT EXISTS Instructor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    password TEXT NOT NULL
);

-- Tạo bảng Post với khóa ngoại tham chiếu đến bảng Instructor
CREATE TABLE IF NOT EXISTS Post (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    instructor_id INTEGER NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES Instructor(id)
);

-- Tạo bảng Comment với khóa ngoại tham chiếu đến bảng Post
CREATE TABLE IF NOT EXISTS Comment (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    content TEXT NOT NULL,
    password TEXT NOT NULL,
    post_id INTEGER NOT NULL,
    FOREIGN KEY (post_id) REFERENCES Post(id)
);


-- Thêm một số dữ liệu mẫu vào bảng Instructor
INSERT INTO Instructor (name, password) VALUES ('Instructor1', 'password123');
INSERT INTO Instructor (name, password) VALUES ('Instructor2', 'password456');
INSERT INTO Instructor (name, password) VALUES ('Instructor3', 'password789');
INSERT INTO Instructor (name, password) VALUES ('Instructor4', 'password321');
INSERT INTO Instructor (name, password) VALUES ('Instructor5', 'password654');

-- Thêm một số dữ liệu mẫu vào bảng Post
INSERT INTO Post (title, content, instructor_id) VALUES ('First Post', 'This is the content of the first post.', 1);
INSERT INTO Post (title, content, instructor_id) VALUES ('Second Post', 'This is the content of the second post.', 2);
INSERT INTO Post (title, content, instructor_id) VALUES ('Third Post', 'This is the content of the third post.', 3);
INSERT INTO Post (title, content, instructor_id) VALUES ('Fourth Post', 'This is the content of the fourth post.', 4);
INSERT INTO Post (title, content, instructor_id) VALUES ('Fifth Post', 'This is the content of the fifth post.', 5);
INSERT INTO Post (title, content, instructor_id) VALUES ('Sixth Post', 'This is the content of the sixth post.', 1);
INSERT INTO Post (title, content, instructor_id) VALUES ('Seventh Post', 'This is the content of the seventh post.', 2);

-- Thêm một số dữ liệu mẫu vào bảng Comment
INSERT INTO Comment (content, password, post_id) VALUES ('This is a comment on the first post.', 'commentpass', 1);
INSERT INTO Comment (content, password, post_id) VALUES ('Another comment on the second post.', 'commentpass', 2);
INSERT INTO Comment (content, password, post_id) VALUES ('Interesting thoughts on the third post.', 'commentpass', 3);
INSERT INTO Comment (content, password, post_id) VALUES ('I disagree with the fourth post.', 'commentpass', 4);
INSERT INTO Comment (content, password, post_id) VALUES ('Nice perspective on the fifth post.', 'commentpass', 5);
INSERT INTO Comment (content, password, post_id) VALUES ('Thanks for sharing on the sixth post.', 'commentpass', 6);
INSERT INTO Comment (content, password, post_id) VALUES ('Can you elaborate on the seventh post?', 'commentpass', 7);
INSERT INTO Comment (content, password, post_id) VALUES ('More details please!', 'commentpass', 1);
INSERT INTO Comment (content, password, post_id) VALUES ('I agree with this post.', 'commentpass', 2);
INSERT INTO Comment (content, password, post_id) VALUES ('Very insightful.', 'commentpass', 3);
