package com.amazen.membership.exposition;

import com.amazen.membership.domain.MemberType;

public class MembershipResponse {
    public String id;
    public MemberType memberType;

    public MembershipResponse(String id, MemberType memberType) {
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
