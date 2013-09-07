# phpass-java
_Java port of the [phpass] library._

This library re-implements the [Portable PHP password hashing framework] password hashing algorithm in Java (direct port), in order to enable user logins and allow authentication against a PHP-based user credentials store.

Most common examples are:

* [Drupal](https://drupal.org) 6 with [phpass module](https://drupal.org/project/phpass)
* [Drupal](https://drupal.org) 7 (or later)
* [TYPO3](http://typo3.org) with [saltedpw extension](http://typo3.org/extensions/repository/view/t3sec-saltedpw)
* [WordPress](http://wordpress.org) 2.5 (or later)

**Note:** At this point, the implementation only supports SHA-512 password hashes that are custom to Drupal.  However, enhancing this library to support the original [phpass] and other custom algorithms is piece of cake, and **pull requests are welcome!** :)

## Requirements

* Java 1.6 or later

## Usage

* To create a new hash for a password:

        createHash(String password);

* To verify a password:

        isMatch(String password, String storedHash);

## License

You may use this software under the terms of the MIT License.


[phpass]: http://www.openwall.com/phpass/
[Portable PHP password hashing framework]: http://www.openwall.com/phpass/
