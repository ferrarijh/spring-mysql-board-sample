package com.jonathan.springjavasample.board.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private int postIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private LocalDateTime datetimeCreated;
    private String creatorId;
    private LocalDateTime datetimeUpdated;
    private String updaterId;
    private String deletedYn;
}

/*
+------------------+--------------+------+-----+---------+----------------+
| Field            | Type         | Null | Key | Default | Extra          |
+------------------+--------------+------+-----+---------+----------------+
| post_idx         | int          | NO   | PRI | NULL    | auto_increment |
| title            | varchar(300) | NO   |     | NULL    |                |
| contents         | text         | NO   |     | NULL    |                |
| hit_cnt          | smallint     | NO   |     | 0       |                |
| datetime_created | datetime     | NO   |     | NULL    |                |
| creator_id       | varchar(50)  | NO   |     | NULL    |                |
| datetime_updated | datetime     | YES  |     | NULL    |                |
| updater_id       | varchar(50)  | YES  |     | NULL    |                |
| deleted_yn       | char(1)      | NO   |     | n       |                |
+------------------+--------------+------+-----+---------+----------------+
 */