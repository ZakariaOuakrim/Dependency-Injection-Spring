<h1 align="center">
  <a href="https://github.com/ZakariaOuakrim/Dependency-Injection-Spring">
    <img src="https://raw.githubusercontent.com/ZakariaOuakrim/Dependency-Injection-Spring/master/src/main/resources/icons/project-icon.png" alt="Dependency-Injection-Spring-java">
  </a>
</h1>
<p align="center">
<a target="_blank" href="https://search.maven.org/artifact/com.webencyclop.core/mftool-java"><img src="https://img.shields.io/maven-central/v/com.webencyclop.core/mftool-java.svg?label=Maven%20Central"/></a> 
<a target="_blank" href="https://www.codacy.com/gh/ankitwasankar/mftool-java/dashboard?utm_source=github.com&utm_medium=referral&utm_content=ankitwasankar/mftool-java&utm_campaign=Badge_Coverage"><img src="https://app.codacy.com/project/badge/Coverage/0054db87ea0f426599c3a30b39291388" /></a>
<a href="https://www.codacy.com/gh/ankitwasankar/mftool-java/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ankitwasankar/mftool-java&amp;utm_campaign=Badge_Grade"><img src="https://app.codacy.com/project/badge/Grade/0054db87ea0f426599c3a30b39291388"/></a>
<a target="_blank" href="https://github.com/ankitwasankar/mftool-java/blob/master/license.md"><img src="https://camo.githubusercontent.com/8298ac0a88a52618cd97ba4cba6f34f63dd224a22031f283b0fec41a892c82cf/68747470733a2f2f696d672e736869656c64732e696f2f707970692f6c2f73656c656e69756d2d776972652e737667" /></a>
&nbsp <a target="_blank" href="https://www.linkedin.com/in/zakariaouakz/"><img height="20" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" /></a>
</p>
<p align="center">
  This repository contains the <strong>Dependency Injection</strong> source code.
   It teaches static and dynamic dependency injection in Java using constructors and getters.
</p>

<p align="center">
<a href="#introduction">Introduction</a> &nbsp;&bull;&nbsp;
<a href="#installation">Installation</a> &nbsp;&bull;&nbsp;
<a href="#Static-Approach">Static-Approach</a> &nbsp;&bull;&nbsp;
<a href="#Dynamic-Approach">Dynamic-Approach</a> &nbsp;&bull;&nbsp;
<a href="#issue">Issue?</a>
</p>

# Introduction
This <b>Dependency Injection</b> teaches dependency injection in Java. You can:

- Implement static dependency injection.
- Implement dynamic dependency injection.
- Use constructors for dependency injection.
- Use getters for dependency injection.
- Integrate this with any Java project.

## Installation
##### Copy the repository
```
git clone https://github.com/ZakariaOuakrim/Dependency-Injection-Spring.git
```

## Static-Approach
Using the static approach with either a getter or constructor:<br/>
```
public static void main(String[] args) {  
    DaoImpl d = new DaoImpl();  
    MetierImpl metier = new MetierImpl(d);  
    //metier.setDao(d); //injection via le setter  
    System.out.println("Resultat "+ metier.calcul());  
}
```


## Dynamic-Approach

Reading from a config file then loading and building the classes with their properties/methods
### 1. Config file
```
dao.DaoImpl  
metier.MetierImpl
```
This approach also provides two options either with a constructor or a setter, the choice between <b>DaoImpl</b> or <b>DaoImpv2</b> depends on the config file
```
public static void main(String[] args) {  
    try {  
        Scanner scanner = new Scanner(new File("config.txt"));  
        String daoClassName = scanner.nextLine();  
        System.out.println("Class: " + daoClassName);  
  
        //DaoImpl d = new DaoImpl();  
        Class cDao=Class.forName(daoClassName);  
        IDao dao = (IDao) cDao.getConstructor().newInstance();  
        System.out.println("Dao: " + dao.getData());  
  
        //MetierImpl metier = new MetierImpl(d);  
        String metierClassName = scanner.nextLine();  
        System.out.println("Metier: " + metierClassName);  
        Class cMetier=Class.forName(metierClassName);  
        //using constructor  
        //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);  
        //using setter        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();  
  
        //metier.setDao(d);  
        Method setDao=cMetier.getDeclaredMethod("setDao", IDao.class);  
        setDao.invoke(metier,dao);  
  
        System.out.println("Resultat "+metier.calcul());  
  
    } catch (Exception e) {  
        System.out.println(e.getMessage());  
    }  
}
```

## Issue
This repository is maintained actively, so if you face any issue please <a href="https://github.com/ZakariaOuakrim/Dependency-Injection-Spring/issues/new">raise an issue</a>.

<h4>Liked the work ?</h4>
Give the repository a star :-)
