CREATE SEQUENCE SEQ_POST;
CREATE TABLE TBL_POST(
    ID NUMBER CONSTRAINT PK_POST PRIMARY KEY,
    POST_TITLE VARCHAR2(255) NOT NULL,
    POST_CONTENT VARCHAR2(255) NOT NULL,
    MEMBER_ID NUMBER NOT NULL,
    CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_POST_MEMBER FOREIGN KEY (MEMBER_ID)
    REFERENCES TBL_MEMBER(ID)
);

ALTER TABLE TBL_POST ADD (POST_READ_COUNT NUMBER DEFAULT 0);

SELECT * FROM (SELECT ROWNUM R, P1.*
               FROM (SELECT ID, POST_TITLE, POST_CONTENT, MEMBER_ID, CREATED_DATE, POST_READ_COUNT, UPDATED_DATE
                     FROM TBL_POST
                     ORDER BY POST_READ_COUNT DESC) P1
               WHERE ROWNUM <= 10) P2
WHERE P2.R >= 1;

SELECT * FROM TBL_POST;
