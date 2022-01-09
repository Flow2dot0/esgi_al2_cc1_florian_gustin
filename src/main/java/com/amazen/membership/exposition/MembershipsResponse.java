package com.amazen.membership.exposition;

import java.util.*;

public class MembershipsResponse {
    public final List<MembershipResponse> members;

    public MembershipsResponse(List<MembershipResponse> members) {
        this.members = members;
    }
}
