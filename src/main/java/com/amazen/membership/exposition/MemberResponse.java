package com.amazen.membership.exposition;

import com.amazen.membership.domain.cc2.MemberType;

public class MemberResponse {
    public String id;
    public MemberType memberType;

    public MemberResponse(String id, MemberType memberType) {
        this.id = id;
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "id='" + id + '\'' +
                ", memberType=" + memberType +
                '}';
    }
}
