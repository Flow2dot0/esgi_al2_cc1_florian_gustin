package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.Entity;

import java.util.List;
import java.util.Objects;

public class Tradesman implements Entity<TradesmanId> {

    private TradesmanId id;
    private Name name;
    private Company company;
    private List<Skill> skills;
    private List<Certificate> certificates;

    private Tradesman(Name name, Company company, List<Skill> skills) {
        this.name = Objects.requireNonNull(name);
        this.company = Objects.requireNonNull(company);
        this.skills = Objects.requireNonNull(skills);
    }

    private Tradesman(TradesmanId id, Name name, Company company, List<Skill> skills) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.company = Objects.requireNonNull(company);
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

    public void setId(TradesmanId id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}
