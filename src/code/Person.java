/**
 * Represents a person with basic attributes like name, birth year, weight, and education level.
 * @author Prince Lesapo and Jimmy Aphane.
 * @version 1.0;
 */
class Person
{
    private final String firstName;
    private final String lastName;
    private final int    birthYear;
    private final String married;
    private final double weightPounds;
    private final String highestEducationLevel;
    public static final int CURRENT_YEAR = 2024;
    public static final double POUNDS_TO_KILOGRAMS = 0.205;

    /**
     * Constructs a new `Person` object with the given details.
     *
     * @param firstName                 The person's first name.
     * @param lastName                  The person's last name.
     * @param birthYear                 The year the person was born.
     * @param married                   The person's marital status ("yes", "no", or "divorced").
     * @param weightPounds              The person's weight in pounds.
     * @param highestEducationLevel     The person's highest level of education ("high school", "undergraduate",
     */
    Person(final String firstName,
           final String lastName,
           final int    birthYear,
           final String married,
           final double weightPounds,
           final String highestEducationLevel)
    {
        if(isValidEducationLevel(highestEducationLevel))
        {
            throw new java.lang.IllegalArgumentException("invalid education level: " + highestEducationLevel);
        }

        if(isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("invalid marriage status: " + married);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.married = married;
        this.weightPounds = weightPounds;
        this.highestEducationLevel = highestEducationLevel;
    }

    /**
     * Constructs a new `Person` object with the given details, assuming the current year for birth year.
     *
     * @param firstName                 The person's first name.
     * @param lastName                  The person's last name.
     * @param married                   The person's marital status ("yes", "no", or "divorced").
     * @param weightPounds              The person's weight in pounds.
     * @param highestEducationLevel     The person's highest level of education ("high school", "undergraduate",
     */
    Person(final String firstName,
           final String lastName,
           final String married,
           final double weightPounds,
           final String highestEducationLevel)
    {
        if(isValidEducationLevel(highestEducationLevel))
        {
            throw new IllegalArgumentException("invalid education level: " + highestEducationLevel);
        }

        if(isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("invalid marriage status: " + married);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.married = married;
        this.weightPounds = weightPounds;
        this.highestEducationLevel = highestEducationLevel;
        this.birthYear = CURRENT_YEAR;
    }

    /**
     * Constructs a new `Person` object with the given details, assuming "high school" education level,
     * "no" marital status, and the current year for birth year.
     *
     * @param firstName    The person's first name.
     * @param lastName     The person's last name.
     * @param weightPounds The person's weight in pounds.
     */
    Person(final String firstName,
           final String lastName,
           final double weightPounds)
    {
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.weightPounds = weightPounds;

        this.birthYear             = CURRENT_YEAR;
        this.highestEducationLevel = "high school";
        this.married               = "no";
    }

    /**
     * Checks if the given education level is valid.
     *
     * @param educationLevelToVerify The education level to check.
     * @return `true` if the education level is valid, `false` otherwise.
     */
    private boolean isValidEducationLevel(final String educationLevelToVerify)
    {
        if(educationLevelToVerify != null && !educationLevelToVerify.isBlank())
        {
            return !educationLevelToVerify.equalsIgnoreCase("high school") &&
                   !educationLevelToVerify.equalsIgnoreCase("undergraduate") &&
                   !educationLevelToVerify.equalsIgnoreCase("graduate");
        }
        return true;
    }

    /**
     * Checks if the given marital status is valid ("yes", "no", or "divorced").
     *
     * @param marriageStatusToVerify The marital status to check.
     * @return `true` if the marital status is valid, `false` otherwise.
     */
    private boolean isValidMarriageStatus(final String marriageStatusToVerify)
    {
        if(marriageStatusToVerify != null && !marriageStatusToVerify.isBlank())
        {
            return !marriageStatusToVerify.equalsIgnoreCase("no") &&
                   !marriageStatusToVerify.equalsIgnoreCase("yes") &&
                   !marriageStatusToVerify.equalsIgnoreCase("divorced");
        }
        return true;
    }

    /**
     * Converts the internal marital status ("yes", "no", or "divorced") to a more human-readable format
     * ("married", "single", or "divorced").
     *
     * @param married The internal marital status ("yes", "no", or "divorced").
     * @return The human-readable marital status ("married", "single", or "divorced").
     */
    private String marriageStatus(final String married)
    {
        if(married.equalsIgnoreCase("yes"))
        {
            return "married";
        } else if(married.equalsIgnoreCase("no"))
        {
            return "single";
        } else
        {
            return "divorced";
        }
    }

    /**
     * Converts the weight from pounds to kilograms if requested.
     *
     * @param kilograms Whether to convert to kilograms (true) or keep pounds (false).
     * @return The weight in the requested unit (pounds or kilograms).
     */
    private double poundsOrKilograms(final boolean kilograms)
    {
        if(kilograms)
        {
            return this.weightPounds / POUNDS_TO_KILOGRAMS;
        }else
        {
            return this.weightPounds;
        }
    }

    /**
    * Prints the person's details in pounds and lower case letters by default.
    */
    public void printDetails()
    {
        System.out.printf("%s %s (%s) was born in %d, weighs %.1f pounds, and has an %s degree!",
                this.firstName, this.lastName, marriageStatus(this.married),
                this.birthYear, this.weightPounds, this.highestEducationLevel);
    }

    /**
     * Prints the person's details with optional weight unit conversion.
     *
     * @param kilograms Whether to print weight in kilograms (true) or pounds (false).
     */
    public void printDetails(boolean kilograms)
    {
        System.out.printf("%s %s (%s) was born in %d, weighs %.1f kilograms, and has an %s degree!",
                this.firstName, this.lastName, marriageStatus(this.married),
                this.birthYear, poundsOrKilograms(kilograms), this.highestEducationLevel);
    }

    /**
     * Prints the person's details with optional weight unit and name capitalization.
     *
     * @param kilograms Whether to print weight in kilograms (true) or pounds (false).
     * @param upperCase Whether to capitalize the first letter of the name (true) or not (false).
     */
    public void printDetails(boolean kilograms, boolean upperCase)
    {
        if(upperCase && kilograms)
        {
            System.out.printf("%s %s (%s) was born in %d, weighs %.1f kilograms, and has an %s degree!",
                    this.firstName.toUpperCase(), this.lastName.toUpperCase(),
                    marriageStatus(this.married), this.birthYear,
                    poundsOrKilograms(true), this.highestEducationLevel);
        } else if (upperCase)
        {
            System.out.printf("%s %s (%s) was born in %d, weighs %.1f pounds, and has an %s degree!",
                    this.firstName.toUpperCase(), this.lastName.toUpperCase(),
                    marriageStatus(this.married), this.birthYear,
                    poundsOrKilograms(false), this.highestEducationLevel);
        } else if(kilograms)
        {
            System.out.printf("%s %s (%s) was born in %d, weighs %.1f kilograms, and has an %s degree!",
                    this.firstName.toLowerCase(), this.lastName.toLowerCase(),
                    marriageStatus(this.married), this.birthYear,
                    poundsOrKilograms(true), this.highestEducationLevel);
        } else
        {
            System.out.printf("%s %s (%s) was born in %d, weighs %.1f pounds, and has an %s degree!",
                   this.firstName.toLowerCase(), this.lastName.toLowerCase(),
                   marriageStatus(this.married), this.birthYear,
                   poundsOrKilograms(false), this.highestEducationLevel);
        }
    }
}
