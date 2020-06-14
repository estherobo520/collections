package edu.ti.caih313.collections.dataobj;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class EmailAddress {
    public enum EmailType {HOME, WORK, SCHOOL}

    public Map<EmailType, String> emailMap;
    HashMap<EmailType, String> emailAddressHashMap = new HashMap<EmailType, String>();

    public EmailAddress(String emailAddress, EmailType type) {
        if (!validate(emailAddress)) {
            throw new InvalidParameterException("Email address not valid: '" + emailAddress + "'");
        }
        emailMap.put(type, emailAddress);
    }

    public String getPrimaryEmailAddress()
    {
        if (emailMap.containsKey(EmailType.HOME))
        {
            return emailMap.get(EmailType.HOME);
        }
        else if (emailMap.containsKey(EmailType.WORK))
        {
            return emailMap.get(EmailType.WORK);
        }
        else if (emailMap.containsKey(EmailType.SCHOOL))
        {
            return emailMap.get(EmailType.SCHOOL);
        }
        else { return null; }
    }

    public String getEmailAddress() {
        return getPrimaryEmailAddress();
    }

    public String getEmailAddress(EmailType type) {
        return emailMap.get(type);
    }

    boolean validate(String emailAddress) {
        return (emailAddress != null) && emailAddress.contains("@");
    }

    @Override
    public String toString()
    {
        StringBuilder emailStringBuilder = new StringBuilder("<");

        if ((getEmailAddress(EmailType.HOME) == null) && (getEmailAddress(EmailType.WORK) == null) && (getEmailAddress(EmailType.SCHOOL) == null)){
            emailStringBuilder.append("<no email address available>");
        }

        if (getEmailAddress(EmailType.HOME) != null) {
            emailStringBuilder.append("<HOME: " + getEmailAddress(EmailType.HOME) + ">");
        }

        if (getEmailAddress(EmailType.WORK) != null) {
            emailStringBuilder.append("<WORK: " + getEmailAddress(EmailType.WORK) + ">");
        }

        if (getEmailAddress(EmailType.SCHOOL) != null) {
            emailStringBuilder.append("<SCHOOL: " + getEmailAddress(EmailType.SCHOOL) + ">");
        }

        emailStringBuilder.append(">");
        return emailStringBuilder.toString();
    }
}
