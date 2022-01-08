package com.amazen.membership.exposition;

import java.util.*;

public class MembersResponse {
    public final List<MemberResponse> members;

    public MembersResponse(List<MemberResponse> members) {
        this.members = members;
    }
}
