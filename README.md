# TP1 - Injection de Dépendances en Java / Spring

Ce projet est réalisé dans le cadre du module **SDIA (science des données et intelligence artificielle)** - M1.

## 📚 Objectif

Implémenter différentes approches d’injection de dépendances :

- ✅ Injection manuelle (via le code Java)
- ✅ Injection dynamique via `Class.forName(...)`
- ✅ Injection via **Spring XML**
- ✅ Injection via **Spring annotations**

---

## 🛠 Structure du projet

src/ ├── net.imad.dao # Interface DAO et son implémentation │ ├── IDao.java │ └── DaoImpl.java ├── net.imad.ext # Deuxième implémentation du DAO │ └── DaoImplV2.java ├── net.imad.metier # Interface métier et son implémentation │ ├── IMetier.java │ └── MetierImpl.java ├── net.imad.pres # Présentations (mains) │ ├── Pres1.java # Injection manuelle │ ├── Pres2.java # Injection dynamique via fichier config.txt │ ├── PresSpringXML.java # Injection avec Spring XML │ └── PresSpringAnnotation.java # Injection avec Spring annotations └── resources/ └── config.xml # Fichier de configuration Spring XML


---

## ▶️ Exécution des différents modes

### 1. 🚀 Injection manuelle (Pres1.java)

```java
DaoImplV2 d = new DaoImplV2();
MetierImpl metier = new MetierImpl(d);
System.out.println("RES = " + metier.calcul());
```

## 2. 🧠 Injection dynamique avec Class.forName (Pres2.java)
Lire les noms de classes DAO et METIER depuis un fichier config.txt

```java
Instancier dynamiquement avec Class.forName(...)
net.imad.ext.DaoImplV2
net.imad.metier.MetierImpl
```


### 3. 🌿 Injection via Spring (XML) – PresSpringXML.java
Utilise ClassPathXmlApplicationContext
Configuration des beans dans config.xml
```java
<bean id="d" class="net.imad.ext.DaoImplV2"/>
<bean id="metier" class="net.imad.metier.MetierImpl">
    <constructor-arg ref="d"/>
</bean>
```
### 4. 🌱 Injection via Spring (Annotations) – PresSpringAnnotation.java
Utilise @Repository, @Component, @Autowired, @Qualifier
ApplicationContext basé sur l’annotation :
```java
ApplicationContext applicationContext = 
    new AnnotationConfigApplicationContext("net.imad");
```



👨‍💻 Auteur
IMAD KHALIFI
GitHub
