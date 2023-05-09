package randomMindustry.random.util;

public class StringGenerator {
    public static final String[] ELEMENTS = new String[]{
            "hydrogen", "oxygen", "carbon", "titanium", "iron", "aluminum", "sulfur", "clorine", "lead", "nitrogen"
    };
    public static final String[] NUMBERS = new String[]{
            " mono", " di", " tri", " penta", " hexa", " hepta", " octa", " nona", " deca", " tetra", " "
    };
    public static final String[] CHEM = new String[]{
            "NEN", "N", "ENEN", "NENENENEN", "NENENE", "NENEN"
    };

    public static String generateSyllable() {
        String sequence = RandomUtil.random(CHEM, RandomUtil.getClientRand());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'N') {
                out.append(RandomUtil.random(NUMBERS, RandomUtil.getClientRand()));
            } else {
                out.append(RandomUtil.random(ELEMENTS, RandomUtil.getClientRand()));
            }
        }
        return out.toString();
    }

    public static String generateWord(int size) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= 1; i++) out.append(generateSyllable());
        return out.toString();
    }
    
    public static String generateNumber(int size) {
        return Integer.toString(RandomUtil.getClientRand().random((int) (Math.pow(10, size - 1)), (int) (Math.pow(10, size) - 1)));
    }

    public static String generateMaterialName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1))).append(generateMaterialSuffix());
        if (RandomUtil.getClientRand().chance(0.5))
            out.append(" ").append(generateMaterialSuffixType());
        return out.toString();
    }

    public static String generateMaterialSuffix() {
        return RandomUtil.random(new String[]{
            "hydride", "oxide", "carbide", "sulfide", "cloride", "nitride", "titanate", "nitrate", "fluoride"
        }, RandomUtil.getClientRand());
    }

    public static String generateMaterialSuffixType() {
        return RandomUtil.random(new String[]{
                "Acid", "Ferrite"
        }, RandomUtil.getClientRand());
    }

    public static String generateTurretName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1)));
        out.append(generateTurretSuffix());
        return out.toString();
    }

    public static String generateTurretSuffix() {
        return RandomUtil.random(new String[]{
                "tre", "re", "ter", "cer", "mer", "er", "orch", "rch",
                "lax", "ment", "ent", "rse", "ite", "te", "se", "le"
        }, RandomUtil.getClientRand());
    }

    public static String generateDrillName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1)));
        out.append(generateDrillSuffix());
        out.append(" Drill");
        return out.toString();
    }

    public static String generateDrillSuffix() {
        return RandomUtil.random(new String[]{
                "pact", "act", "matic", "atic", "chal", "al", "ser", "er",
                "ption", "tion", "blast", "last", "ast", "tary", "pulse"
        }, RandomUtil.getClientRand());
    }

    public static String generateCoreName() {
        StringBuilder out = new StringBuilder();
        out.append("Core: ");
        out.append(capitalizeFirstLetter(generateWord(RandomUtil.getClientRand().random(1, 2))));
        out.append(generateCoreSuffix());
        return out.toString();
    }

    public static String generateCoreSuffix() {
        return RandomUtil.random(new String[]{
                "ard", "rd", "ation", "tion", "cleus", "leus",
                "tadel", "adel", "del", "opolis", "polis", "olis",
                "cite", "ite", "uin", "crete", "rete"
        }, RandomUtil.getClientRand());
    }

    public static String generateUnitName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1)));
        out.append(generateUnitSuffix());
        return out.toString();
    }

    public static String generateUnitSuffix() {
        return RandomUtil.random(new String[]{
                "ger", "ace", "ress", "pter", "eign",
                "va", "lsar", "asar", "la", "vus",
                "ler", "rax", "roct", "yid", "pid",
                "are", "zon", "ith", "ra", "ipse",
                "no", "ly", "ga", "ad", "ct",
                "sso", "ke", "yde", "ei", "ura",
                "usa", "noe", "erce", "ires", "nax",
                "pha", "eta", "mma",
                "ell", "cus", "ept", "ish", "quer",
                "rui", "roi", "us", "cta", "aris",
                "ude", "vert", "ate", "ll", "upt",
                "oke", "cite", "nate"
        }, RandomUtil.getClientRand());
    }
    
    public static String generateUnitFactoryName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1)));
        out.append(generateUnitFactorySuffix());
        out.append(" " + RandomUtil.random(new String[]{ "Fabricator", "Constructor", "Builder", "Factory", "Assembler" }, RandomUtil.getClientRand()));
        return out.toString();
    }
    
    public static String generateUnitFactorySuffix() {
        return RandomUtil.random(new String[]{
                "ound", "und", "nd", "ir", "val", "al", "ank", "nk", "ip",
                "ech", "ch", "on", "ron", "tron", "ute", "nide", "ide"
        }, RandomUtil.getClientRand());
    }
    
    public static String generateReconstructorName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(1)));
        out.append(generateReconstructorSuffix());
        out.append(" " + RandomUtil.random(new String[]{ "Refabricator", "Reconstructor" }, RandomUtil.getClientRand()));
        return out.toString();
    }
    
    public static String generateReconstructorSuffix() {
        return RandomUtil.random(new String[]{
                "ditive", "cative", "nential", "ential", "tial", "trative",
                "itive", "ative", "rative", "tive"
        }, RandomUtil.getClientRand());
    }
    
    public static String generateSectorName() {
        StringBuilder out = new StringBuilder();
        out.append(capitalizeFirstLetter(generateWord(2)));
        if (RandomUtil.getClientRand().chance(0.75f)) {
            out.append(" " + generateSectorPlace());
            if (RandomUtil.getClientRand().chance(0.25f)) out.append(" " + generateNumber(3));
        }
        return out.toString();
    }
    
    public static String generateSectorPlace() {
        return RandomUtil.random(new String[]{
                "Market", "Zero", "Facility", "Craters", "Canyons", "Floors", "Mountains",
                "Meteor", "Ruins", "Shores", "Bunker", "Flats", "Battlefield", "Impact"
        }, RandomUtil.getClientRand());
    }

    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
