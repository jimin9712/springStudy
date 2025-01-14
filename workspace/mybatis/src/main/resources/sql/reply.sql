CREATE SEQUENCE SEQ_REPLY;

DROP TABLE TBL_REPLY;

CREATE TABLE TBL_REPLY (
    ID NUMBER CONSTRAINT PK_REPLY PRIMARY KEY,
    REPLY_CONTENT VARCHAR2(255) NOT NULL,
    MEMBER_ID NUMBER NOT NULL,
    POST_ID NUMBER NOT NULL,
    GROUP_ID NUMBER,
    REPLY_DEPTH NUMBER DEFAULT 1,
    CREATED_DATE DATE DEFAULT SYSDATE,
    UPDATED_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT FK_REPLY_MEMBER FOREIGN KEY(MEMBER_ID) REFERENCES TBL_MEMBER(ID),
    CONSTRAINT FK_REPLY_POST FOREIGN KEY(POST_ID) REFERENCES TBL_POST(ID)
--  ON DELETE CASCADE
);

SELECT * FROM TBL_REPLY;

SELECT * FROM  TBL_MEMBER;

SELECT * FROM TBL_POST;