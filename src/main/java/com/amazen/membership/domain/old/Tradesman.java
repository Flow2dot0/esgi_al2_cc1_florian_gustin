package com.amazen.membership.domain.old;

import com.amazen._kernel.abstracts.Entity;
import com.amazen._kernel.value_objects.Name;
import com.amazen._subscription.Subscription;
import com.amazen.membership.domain.cc2.Company;
import com.amazen.membership.domain.cc2.Password;
import com.amazen.membership.domain.cc2.Skill;

import java.util.List;
import java.util.Objects;

public class Tradesman implements Entity<TradesmanId> {

    private TradesmanId id;
    private Name name;
    private List<Skill> skills;
    private List<Certificate> certificates;
    private Subscription subscription;
    private Password password;

    private Tradesman(Name name, Company company, List<Skill> skills) {
        this.name = Objects.requireNonNull(name);
        this.skills = Objects.requireNonNull(skills);
    }

    private Tradesman(TradesmanId id, Name name, Company company, List<Skill> skills) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.skills = Objects.requireNonNull(skills);
    }

    static Tradesman of(Name name, Company company, List<Skill> skills) {
        return new Tradesman(name, company, skills);
    }

    static Tradesman withId(TradesmanId id, Name name, Company company, List<Skill> skills) {
        return new Tradesman(id, name, company, skills);
    }

    @Override
    public TradesmanId getId() {
        return id;
    }

    @Override
    public void setId(TradesmanId id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
