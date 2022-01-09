package com.amazen.membership.exposition;

import com.amazen.membership.domain.MemberType;

public class MembershipResponse {
    public Integer id;
    public String memberType;

    public MembershipResponse(Integer id, String memberType) {
        this.id = id;
        this.memberType = memberType;
    }

    public MembershipResponse(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "id='" + id + '\'' +
                ", memberType=" + memberType +
                '}';
    }
}
