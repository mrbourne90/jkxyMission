-- 教师表
CREATE TABLE teacher (
    `tid` INT NOT NULL AUTO_INCREMENT COMMENT '',
    `tname` VARCHAR(45) NULL COMMENT '',
    PRIMARY KEY (`tid`) COMMENT ''
);
-- 学生表
CREATE TABLE student (
    `sid` INT NOT NULL AUTO_INCREMENT COMMENT '',
    `sname` VARCHAR(45) NULL COMMENT '',
    `gender` VARCHAR(2) NULL COMMENT '',
    PRIMARY KEY (`sid`) COMMENT ''
);
-- 课程表
CREATE TABLE course (
    `cid` INT NOT NULL AUTO_INCREMENT COMMENT '',
    `cname` VARCHAR(45) NULL COMMENT '',
    `tid` INT NOT NULL COMMENT '教师id',
    PRIMARY KEY (`cid`) COMMENT ''
);
-- 成绩表
CREATE TABLE score (
    `scid` INT NOT NULL AUTO_INCREMENT COMMENT '',
    `sid` INT NOT NULL COMMENT '学生id',
    `cid` INT NOT NULL COMMENT '课程id',
    `grade` DECIMAL(4 , 1 ) NOT NULL COMMENT '分数',
    PRIMARY KEY (`scid`) COMMENT ''
);
-- 插入数据
INSERT INTO teacher (`tname`) VALUES ('张三');
INSERT INTO teacher (`tname`) VALUES ('李四');
INSERT INTO teacher (`tname`) VALUES ('王五');
INSERT INTO teacher (`tname`) VALUES ('赵六');
INSERT INTO student (`sname`, `gender`) VALUES ('赵四', '男');
INSERT INTO student (`sname`, `gender`) VALUES ('刘能', '男');
INSERT INTO student (`sname`, `gender`) VALUES ('大脚', '女');
INSERT INTO student (`sname`, `gender`) VALUES ('香秀', '女');
INSERT INTO course (`cname`, `tid`) VALUES ('语文', '1');
INSERT INTO course (`cname`, `tid`) VALUES ('数学', '1');
INSERT INTO course (`cname`, `tid`) VALUES ('英语', '3');
INSERT INTO course (`cname`, `tid`) VALUES ('物理', '4');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('1', '1', '86');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('1', '2', '45');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('1', '3', '68');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('1', '4', '75');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('2', '1', '59');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('2', '2', '98');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('2', '3', '65');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('2', '4', '35');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('3', '1', '99');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('3', '2', '85');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('3', '3', '67');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('3', '4', '75');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('4', '1', '76');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('4', '2', '69');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('4', '3', '95');
INSERT INTO score (`sid`, `cid`, `grade`) VALUES ('4', '4', '96');

-- 查询所有选修数学的女生
SELECT 
    student.*
FROM
    student
        JOIN
    score
        JOIN
    course ON student.sid = score.sid
        AND score.cid = course.cid
WHERE
    cname = '数学' AND gender = '女';

-- 查询每门课程平均成绩
SELECT 
    course.cname 课程, AVG(score.grade) 平均成绩
FROM
    score
        JOIN
    course ON score.cid = course.cid
GROUP BY course.cname;

-- 查询每门课程成绩最高的学生
SELECT 
    sname 学生姓名, cname 课程, grade 分数
FROM
    score
        JOIN
    student
        JOIN
    course ON score.sid = student.sid
        AND score.cid = course.cid
WHERE
    score.grade IN (SELECT 
            MAX(score.grade)
        FROM
            score
        GROUP BY score.cid);

-- 查询张三教师所教学生的课程成绩表
SELECT 
    student.sname 学生姓名,
    student.gender 性别,
    course.cname 课程,
    teacher.tname 教师,
    score.grade 分数
FROM
    score
        JOIN
    student
        JOIN
    teacher
        JOIN
    course ON score.sid = student.sid
        AND score.cid = course.cid
        AND course.tid = teacher.tid
WHERE
    tname = '张三';