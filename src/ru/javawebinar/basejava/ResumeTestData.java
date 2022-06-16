package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        initContacts(resume);
        initSections(resume);
        print(resume);
    }

    public static Resume getTestResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        initContacts(resume);
        initSections(resume);
        return resume;
    }

    private static void initContacts(Resume resume) {
        Map<ContactType, String> contacts = resume.getContacts();
        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB, "https://github.com/gkislin");
        contacts.put(ContactType.STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.HOME_PAGE, "http://gkislin.ru/");
    }

    private static void initSections(Resume resume) {
        Map<SectionType, Section> sections = resume.getSections();
        initObjective(sections);
        initPersonal(sections);
        initAchievement(sections);
        initQualifications(sections);
        initExperience(sections);
        initEducation(sections);
    }

    private static void print(Resume resume) {
        System.out.println(resume.getFullName());
        for (Map.Entry<ContactType, String> pair : resume.getContacts().entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        for (Map.Entry<SectionType, Section> pair : resume.getSections().entrySet()) {
            System.out.println("\n" + pair.getKey().getTitle() + ":\n" + pair.getValue());
        }
    }

    private static void initObjective(Map<SectionType, Section> sections) {
        sections.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения" +
                " по Java Web и Enterprise технологиям"));
    }

    private static void initPersonal(Map<SectionType, Section> sections) {
        sections.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность" +
                ", инициативность. Пурист кода и архитектуры."));
    }

    private static void initAchievement(Map<SectionType, Section> sections) {
        List<String> achievements = new ArrayList<>();
        achievements.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения " +
                "автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на " +
                "Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для" +
                " комплексных DIY смет");
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 3500 выпускников.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция " +
                "с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring," +
                " Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов" +
                " (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии " +
                "через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга " +
                "системы по JMX (Jython/ Django).");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        sections.put(SectionType.ACHIEVEMENT, new ListSection(achievements));
    }

    private static void initQualifications(Map<SectionType, Section> sections) {
        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, " +
                "SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring " +
                "(MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT)," +
                " Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, " +
                "DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, " +
                "OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, " +
                "iReport, OpenCmis, Bonita, pgBouncer");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");
        sections.put(SectionType.QUALIFICATIONS, new ListSection(qualifications));
    }

    private static void initExperience(Map<SectionType, Section> sections) {
        List<Organization> organizations = new ArrayList<>();

        List<Position> javaOnlineProjectsPositions = new ArrayList<>();
        javaOnlineProjectsPositions.add(new Position(DateUtil.of(2013, Month.OCTOBER),
                DateUtil.of(2022, Month.JUNE), "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        organizations.add(new Organization(new Link("Java Online Projects",  "http://javaops.ru/"),
                javaOnlineProjectsPositions));

        List<Position> wrikePositions = new ArrayList<>();
        wrikePositions.add(new Position(DateUtil.of(2014, Month.OCTOBER),
                DateUtil.of(2016, Month.JANUARY), "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, " +
                        "Maven, " + "Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная " +
                        "аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        organizations.add(new Organization(new Link("Java Online Projects",  "https://www.wrike.com/"),
                wrikePositions));

        List<Position> ritCenterPositions = new ArrayList<>();
        ritCenterPositions.add(new Position(DateUtil.of(2012, Month.APRIL),
                DateUtil.of(2014, Month.OCTOBER), "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика," +
                        " версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                        "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части " +
                        "системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего " +
                        "назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
                        "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache " +
                        "Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python " +
                        "scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        organizations.add(new Organization(new Link("RIT Center",  null),
                ritCenterPositions));

        List<Position> luxoftPositions = new ArrayList<>();
        luxoftPositions.add(new Position(DateUtil.of(2010, Month.DECEMBER),
                DateUtil.of(2012, Month.APRIL), "Разработчик ПО",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, " +
                        "GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация " +
                        "RIA-приложения для администрирования, мониторинга и анализа результатов в области" +
                        " алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, " +
                        "HTML5."));
        organizations.add(new Organization(new Link("Luxoft (Deutsche Bank)",  "http://www.luxoft.ru/"),
                luxoftPositions));

        List<Position> yotaPositions = new ArrayList<>();
        yotaPositions.add(new Position(DateUtil.of(2008, Month.JUNE),
                DateUtil.of(2010, Month.DECEMBER), "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish " +
                        "v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация" +
                        " администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента" +
                        " (Python/ Jython, Django, ExtJS)"));
        organizations.add(new Organization(new Link("Yota",  "https://www.yota.ru/"),
                yotaPositions));

        List<Position> enkataPositions = new ArrayList<>();
        enkataPositions.add(new Position(DateUtil.of(2007, Month.MARCH),
                DateUtil.of(2008, Month.JUNE), "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS)" +
                        " частей кластерного J2EE приложения (OLAP, Data mining)."));
        organizations.add(new Organization(new Link("Enkata",  "http://enkata.com/"),
                enkataPositions));

        List<Position> siemensPositions = new ArrayList<>();
        siemensPositions.add(new Position(DateUtil.of(2005, Month.JANUARY),
                DateUtil.of(2007, Month.FEBRUARY), "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на " +
                        "мобильной IN платформе Siemens @vantage (Java, Unix)."));
        organizations.add(new Organization(new Link("Siemens AG",  "https://www.siemens.com/ru/ru/home.html"),
                siemensPositions));

        List<Position> alcatelPositions = new ArrayList<>();
        alcatelPositions.add(new Position(DateUtil.of(1997, Month.SEPTEMBER),
                DateUtil.of(2005, Month.JANUARY), "Инженер по аппаратному и программному" +
                " тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции " +
                "Alcatel 1000 S12 (CHILL, ASM)."));
        organizations.add(new Organization(new Link("Alcatel",  "http://www.alcatel.ru/"),
                alcatelPositions));

        sections.put(SectionType.EXPERIENCE, new OrganizationSection(organizations));
    }

    private static void initEducation(Map<SectionType, Section> sections) {
        List<Organization> organizations = new ArrayList<>();

        List<Position> courseraPositions = new ArrayList<>();
        courseraPositions.add(new Position(DateUtil.of(2013, Month.MARCH),
                DateUtil.of(2013, Month.MAY), "'Functional Programming Principles in Scala'" +
                "by Martin Odersky", null));
        organizations.add(new Organization(new Link("Coursera",  "https://www.coursera.org/course/progfun"),
                courseraPositions));

        List<Position> luxoftPositions = new ArrayList<>();
        luxoftPositions.add(new Position(DateUtil.of(2011, Month.MARCH),
                DateUtil.of(2011, Month.JUNE), "Курс 'Объектно-ориентированный анализ ИС. " +
                "Концептуальное моделирование на UML.'", null));
        organizations.add(new Organization(new Link("Luxoft",
                "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"),
                luxoftPositions));

        List<Position> siemensPositions = new ArrayList<>();
        siemensPositions.add(new Position(DateUtil.of(2005, Month.JANUARY),
                DateUtil.of(2005, Month.APRIL), "3 месяца обучения мобильным IN сетям (Берлин)",
                null));
        organizations.add(new Organization(new Link("Siemens AG",  "https://www.siemens.com/ru/ru/home.html"),
                siemensPositions));

        List<Position> alcatelPositions = new ArrayList<>();
        alcatelPositions.add(new Position(DateUtil.of(1997, Month.SEPTEMBER),
                DateUtil.of(1998, Month.MARCH),
                "6 месяцев обучения цифровым телефонным сетям (Москва)", null));
        organizations.add(new Organization(new Link("Alcatel",  "http://www.alcatel.ru/"),
                alcatelPositions));

        List<Position> itmoPositions = new ArrayList<>();
        itmoPositions.add(new Position(DateUtil.of(1993, Month.SEPTEMBER),
                DateUtil.of(1996, Month.JULY), "Аспирантура (программист С, С++)",
                null));
        itmoPositions.add(new Position(DateUtil.of(1987, Month.SEPTEMBER),
                DateUtil.of(1993, Month.JULY), "Инженер (программист Fortran, C)",
                null));
        organizations.add(new Organization(new Link("Санкт-Петербургский национальный исследовательский" +
                " университет информационных технологий, механики и оптики",  "http://www.ifmo.ru/"),
                itmoPositions));

        List<Position> schoolPositions = new ArrayList<>();
        schoolPositions.add(new Position(DateUtil.of(1984, Month.SEPTEMBER),
                DateUtil.of(1987, Month.JUNE), "Закончил с отличием",
                null));
        organizations.add(new Organization(new Link("Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/"),
                schoolPositions));

        sections.put(SectionType.EDUCATION, new OrganizationSection(organizations));
    }
}
