DROP TABLE TBL_POST;

CREATE SEQUENCE SEQ_POST;
INSERT INTO TBL_MEMBER (ID, MEMBER_NAME, MEMBER_AGE, MEMBER_EMAIL, MEMBER_PASSWORD, STATUS)
VALUES (SEQ_POST.nextval, '이세찬', 25, 'ljm@example.com', '1234', 1);

CREATE TABLE TBL_POST(
    ID NUMBER CONSTRAINT PK_POST PRIMARY KEY,
    POST_TITLE VARCHAR2(255) NOT NULL,
    POST_CONTENT VARCHAR2(255) NOT NULL,
    POST_READ_COUNT NUMBER DEFAULT 0,
    STATUS NUMBER DEFAULT 1,
    CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    MEMBER_ID NUMBER,
    CONSTRAINT FK_POST_MEMBER FOREIGN KEY(MEMBER_ID)
    REFERENCES TBL_MEMBER(ID)
);

INSERT INTO TBL_POST(ID,POST_TITLE,POST_CONTENT,POST_READ_COUNT,STATUS,CREATED_DATE,UPDATED_DATE,MEMBER_ID)
VALUES (SEQ_POST.nextval,'제목','내용',null,1,SYSDATE,SYSDATE,8);

ALTER TABLE TBL_POST ADD MEMBER_ID NUMBER;
ALTER TABLE TBL_POST ADD CONSTRAINT FK_POST_MEMBER FOREIGN KEY(MEMBER_ID)
REFERENCES TBL_MEMBER(ID);

SELECT * FROM TBL_POST;

SELECT * FROM TBL_MEMBER;