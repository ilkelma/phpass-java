package com.mollom.phpass;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PasswordHasherTest {
  private PasswordHasher hasher;
  
  @Before
  public void setup() {
    hasher = new PasswordHasher();
  }
  
  @Test
  public void testIsMatch_matchesCorrectSolution() {
    // Test multiple cases, just in case
    assertTrue(hasher.isMatch("huan", "$S$DXZrp425p2VN9LXpDWxiBeqSZSPexyZNNPUo80fTTN2e/W15a97G"));
    assertTrue(hasher.isMatch("Cookies1", "$S$Dr3Hm8Od9X0Ux/olZ.B8Uwh6./3E1l4nPfXebovKVvMB9zcmjkTn"));
  }

  @Test
  public void testIsMatch_failsIncorrectSolution() {
    assertFalse(hasher.isMatch("OHH NO! Not cookies!", "$S$Dr3Hm8Od9X0Ux/olZ.B8Uwh6./3E1l4nPfXebovKVvMB9zcmjkTn"));
  }

  @Test
  public void testIsMatch_failsEmptySolution() {
    assertFalse(hasher.isMatch("", "$S$Dr3Hm8Od9X0Ux/olZ.B8Uwh6./3E1l4nPfXebovKVvMB9zcmjkTn"));
  }

  @Test
  public void testCreateHash_matchesOriginalPassword() {
    String password = "ThisIs@C♥mplexPÃssword™123";
    String hash = hasher.createHash(password);
    assertTrue(hasher.isMatch(password, hash));
    assertFalse(hasher.isMatch("NotTheSamePassword", hash));
  }
}
