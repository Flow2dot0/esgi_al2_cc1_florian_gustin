package com.amazen;

import static org.junit.Assert.assertTrue;

import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._marketplace.domain.builders.AccountBuilder;
import com.amazen._marketplace.domain.entities.Account;
import com.amazen._marketplace.domain.entities.AccountType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldBuildAccountSuccess() throws ValueObjectException {
        Account account = new AccountBuilder()
                .withEmail("billgates@gmail.com")
                .withPassword("1234123412341234L")
                .withFirstname("Bill")
                .withLastname("Gates")
                .withAddress("1 rue de la fenêtre")
                .withZipcode(75001)
                .withCity("Paris")
                .withCountry("France")
                .withCompany("MICROSOFT")
                .withSiret("E1234")
                .withAccountType(AccountType.TRADESMAN)
                .build();
        Assert.assertNotNull(account);
    }

    @Test
    public void shouldBuildAccountFailed(){
        Account account = null;
        try {
            account = new AccountBuilder()
                    .withEmail("billgates@gmail.com")
                    .withPassword("123")
                    .withFirstname("Bill")
                    .withLastname("Gates")
                    .withAddress("1 rue de la fenêtre")
                    .withZipcode(75001)
                    .withCity("Paris")
                    .withCountry("France")
                    .withCompany("MICROSOFT")
                    .withSiret("E1234")
                    .withAccountType(AccountType.TRADESMAN)
                    .build();
            Assert.assertNull(account);
        } catch (Exception e) {
            Assert.assertNull(account);
        }
    }

    @Test
    public void shouldRegisterAccountSuccess(){

    }

    @Test
    public void shouldRegisterAccountFailed(){

    }

    @Test
    public void shouldPaymentSuccess(){

    }

    @Test
    public void shouldPaymentFailed(){

    }

    @Test
    public void shouldRegisterTransactionSuccess(){

    }

    @Test
    public void shouldRegisterTransactionFailed(){

    }

    @Test
    public void shouldRegisterMembershipSuccess(){

    }

    @Test
    public void shouldRegisterMembershipFailed(){

    }
}
