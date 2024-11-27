CREATE TABLE TBL_NOTIFICATION (
    ID NUMBER PRIMARY KEY,
    USER_ID NUMBER NOT NULL,
    MESSAGE VARCHAR2(255) NOT NULL,
    CREATED_DATE DATE DEFAULT SYSDATE,
    IS_READ NUMBER DEFAULT 0,           -- 읽음 상태 0 => 안읽음, 1=> 읽음
    CONSTRAINT FK_NOTIFICATION_USER FOREIGN KEY (USER_ID)
        REFERENCES TBL_MEMBER(ID)
);


CREATE SEQUENCE SEQ_NOTIFICATION;

SELECT * FROM TBL_NOTIFICATION;