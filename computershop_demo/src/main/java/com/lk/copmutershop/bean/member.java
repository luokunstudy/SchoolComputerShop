package com.lk.copmutershop.bean;

import javax.validation.constraints.Pattern;

public class member {
	
    private String account;

    private String password;

    private Integer sex;

    private String telephone;

    private String email;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	@Override
	public String toString() {
		return "member [account=" + account + ", password=" + password + ", sex=" + sex + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

	public member(String account, String password, Integer sex, String telephone, String email) {
		super();
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
	}

	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}