package com.amazen.membership.infrastructure;

import com.amazen.membership.domain.cc2.Member;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;

import java.util.Collection;
import java.util.Objects;

@Repository
public class MemberInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Member> {

    @Override
    public Member save(Member member) {
        member.setId(Objects.nonNull(member.getId()) ? member.getId() : nextId());
        data.put(member.getId(), member);
        return data.get(member.getId());
    }

    @Override
    public MemberID nextId() {
        return new MemberID(count.incrementAndGet());
    }

}
