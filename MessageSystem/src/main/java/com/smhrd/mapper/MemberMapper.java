package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.model.WebMember;

// mapper interface 지정해주는 annotation
@Mapper
public interface MemberMapper {
	
	// 만약 반환값 있을경우 insert는 int로 반환
	public void joinMember(WebMember member);

	@Select("select * from webmember where email=#{email} and pw=#{pw}")
	public WebMember loginMember(WebMember member);
	
	@Update("update webmember set pw=#{pw}, tel=#{tel}, address=#{address} where email=#{email}")
	public void updateMember(WebMember member);
	
	@Select("select * from webmember")
	public List<WebMember> selectAllMember();
	
	@Delete("delete from webmember where email=#{email}")
	public void deleteMember(String email);
}
