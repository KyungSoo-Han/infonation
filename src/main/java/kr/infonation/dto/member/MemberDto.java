package kr.infonation.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long member_id;
    private String name;
    private String email;

}