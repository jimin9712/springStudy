package com.app.mythreetier.domain.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Search {
    String keyword;
    String[] types;
}
