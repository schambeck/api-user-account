package br.com.sbt.useraccount.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAccountMapper {

    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

    UserAccount toEntity(UserAccountRequestWeb web);

    UserAccountWeb toWeb(UserAccount userAccount);

}