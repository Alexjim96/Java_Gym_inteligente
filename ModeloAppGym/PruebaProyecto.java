/**
    Clase de prueba para cada uno de los metodos
    de las clases del proyecto GYM VIRTUAl
*/
import java.io.IOException;
import java.text.SimpleDateFormat;  // Para formato
import java.util.*;  // Para fechas
public class PruebaProyecto{
    public static void main(String[] args) {
        int opcion = 0;
        while(opcion!=7){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                /*No hacer nada*/
            }
            Libreria.imprime("****BIENVENIDO A GYM VIRTUAL!****\n");
            Libreria.imprime("\t*************");
            Libreria.imprime("\t*    MENU   *");
            Libreria.imprime("\t*************\n");
            Libreria.imprime("\t1. Clase Usuario");
            Libreria.imprime("\t2. Clase Objetivo");
            Libreria.imprime("\t3. Clase Ejercicos");
            Libreria.imprime("\t4. Clase Plan de Entrenamiento");
            Libreria.imprime("\t5. Clase Plan de Alimentación");
            Libreria.imprime("\t6. Clase Objetivo de Alimentación");
            Libreria.imprime("\t7. Clase Comida");
            Libreria.imprime("\t8. Salir\n");
            opcion = Libreria.capturaEntero("Seleccione una opción del menú: ",1,8);
            switch(opcion){
                case 1:
                    pruebaUser();
                    break;
                case 2:
                    pruebaGoal();
                    break;
                case 3:
                    pruebaExcercises();
                    break;
                case 4:
                    pruebaTraining();
                    break;
                case 5:
                	pruebaFoodPlan();
                    break;
                case 6:
                	pruebaDietGoal();
                    break;
                case 7:
                	pruebaFood();
                    break;
                case 8:
                    break;
                default:
                    Libreria.imprime("Opción no valida, intenta de nuevo\n");
            }
        }
    }
    public static void pruebaUser(){
        User user1 = new User();
        User user2 = new User("Juan","juan@mail.com",23,"12as3",1.78,76,'M');

        Libreria.imprime("****Bienvenido al registro****\nIngresa los datos siguientes.");
        user1.setUserName(Libreria.capturaTexto("Nombre: "));
        if(user1.getUserName().equals("Sin nombre")){
            Libreria.imprime("Nombre fuera del rango de caracteres permitidos");
        }
        user1.setEmail(Libreria.capturaTexto("Email: "));
        user1.setAge(Libreria.capturaEntero("Edad: ",0,100));
        user1.setPassword(Libreria.capturaTexto("Contraseña: "));
        if(user1.getPassword().equals("NA")){
            Libreria.imprime("Contraseña demasiado corta, debe tener al menos 8 caracteres");
        }
        user1.setSex(Libreria.capturaChar("Sexo(F/M): "));
        if(user1.getSex()=='N'){
            Libreria.imprime("Letra ingresada de manera incorrecta, debes ser F o M");
        }
        user1.setWeight(Libreria.capturaDoble("Peso: ",0,1000));
        user1.setHeight(Libreria.capturaDoble("Estatura(en metros): ",0,1000));
        user1.setIdUser(1);
        user1.setImc();
        if(user1.getImc()==0){
            Libreria.imprime("El peso y la estatura debe ser mayor que cero");
        }
        System.out.println("Registro: "+user1.signin());
        System.out.println();

        Libreria.imprime("****Prueba de inicio de sesión****");
        System.out.println("Inicio: "+user1.login(Libreria.capturaTexto("Usuario: "),Libreria.capturaTexto("Contraseña: ")));
        System.out.println();

        user2.setImc();
        Libreria.imprime("Creacion de usuario con nombre: "+user2.getUserName());
		System.out.printf("IMC de %s: %.1f\n",user2.getUserName(),user2.getImc());
        System.out.printf("Tu IMC: %.1f\n",user1.getImc());
        Libreria.imprime("El usuario "+user2.getUserName()+" es igual a "+user1.getUserName()
                         +": "+user1.equals(user2));
        System.out.println();

        Libreria.imprime("****Prueba recupera contraseña****");
        System.out.println("Contraseña recuperada: "+user1.recoverPassword(Libreria.capturaTexto("Nueva contraseña: ")));

        System.out.println();
        Libreria.imprime("****Prueba Obtiene Entrenamiento****");
        System.out.println(user1.getTrainPlan());

        System.out.println();
        Libreria.imprime("****Prueba Obtiene Plan de Alimentación****");
        //System.out.println(user1.getFoodPlan());

        System.out.println();
        Libreria.imprime("********************************");
        Libreria.imprime(user1.toString());
        Libreria.imprime("********************************");
        Libreria.imprime(user2.toString());

        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaExcercises(){
        /* Prueba de la clase Excercises */
        Libreria.imprime("\t\t\t***** Prueba de la clase Excercises *****");
        Excercises ejDefault = new Excercises();  // Ejercicio con constructor por default
        Excercises ejerc1 = new Excercises("Pesas", 5, 10, "Banco", 3, "Peso de 5Kg");
        Excercises ejerc5 = new Excercises("Remo", 5, 10, "Poleas", 2, "Peso de 5Kg");
        Excercises ejerc14 = new Excercises("Croisant", 5, 10, "N/A", 1, "Peso de 5Kg");
        /* Prueba del método toString */
        Libreria.imprime("Datos de 4 ejercicios distintos (incluyendo el creado con el constructor sin parámetros) usando toString:");
        Libreria.imprime(ejDefault.toString());
        Libreria.imprime(ejerc1.toString());
        Libreria.imprime(ejerc5.toString());
        Libreria.imprime(ejerc14.toString());

        /* Prueba de métodos Set y Get
           Para probar estos métodos se corregirá la información del ejercicio 14
           que es creado con el nombre Croisant */
        Libreria.imprime("Uso de los métodos set para cambiar los atributos del ejercicio llamado Croisant");
        ejerc14.setName("Crossfit");
        ejerc14.setNumSeries(3);
        ejerc14.setRepetition(0);
        ejerc14.setMachine("N/A");
        ejerc14.setType(2);
        ejerc14.setWarmup("Calentamiento ligero.");

        /* Visualización del ejercicio 14 a traves de los métodos get */
        Libreria.imprime("Visualización de los atributos del ejercicio modificado a través de los métodos get:");
        Libreria.imprime("El nombre del ejercicio 14 es: " + ejerc14.getName());
        Libreria.imprime("El tipo del ejercicio 14 es: " + ejerc14.getType());
        Libreria.imprime("En el ejercicio 14 se hacen " + ejerc14.getNumSeries() + " series");
        Libreria.imprime("En el ejercicio 14 cada serie es de: " + ejerc14.getRepetition() + " repeticiones" );
        Libreria.imprime("El ejercicio 14 se hace en la maquina: " + ejerc14.getMachine());
        Libreria.imprime("El Calentamiento del ejercicio 14 es: " + ejerc14.getWarmup());

        /* Prueba del método equals de la clase Excercises */
        Libreria.imprime("Prueba de los métodos equals:");
        Libreria.imprime("Comparación ejercicios 1 y 14 (no son iguales.)");
        Libreria.imprime((ejerc14.equals(ejerc1))? "Son iguales." : "No son iguales.");
        Libreria.imprime("Se cambian los datos de ejercicio default para que coincidan con el ejercicio 14");

        ejDefault.setName("Crossfit");
        ejDefault.setNumSeries(3);
        ejDefault.setRepetition(0);
        ejDefault.setMachine("N/A");
        ejDefault.setType(2);
        ejDefault.setWarmup("Calentamiento ligero.");

        Libreria.imprime("Comparación ejercicios 14 y default (son iguales.)");
        Libreria.imprime((ejerc14.equals(ejDefault))? "Son iguales." : "No son iguales.");
        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaGoal(){
        /* Prueba de la clase Goal */
        Libreria.imprime("\t\t\t***** Prueba de la clase Goal *****");
        SimpleDateFormat formatoEsMX = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("ES", "MX"));
        Libreria.imprime("Se crean 4 metas distintas: 1 sin información y cada una de las otras 3 con un nombre específico.");
        /* Meta ganar masa muscular */
        Goal meta1 = new Goal(0);
        /* Meta bajar de peso */
        Goal meta2 = new Goal(1);
        /* Meta mantener peso */
        Goal meta3 = new Goal(2);
        /* Meta default */
        Goal metaDef = new Goal();
        /* Visualización de las metas */
        Libreria.imprime("\nInformación de las metas usando el método toString");
        Libreria.imprime(meta1.toString());
        Libreria.imprime(meta2.toString());
        Libreria.imprime(meta3.toString());
        Libreria.imprime(metaDef.toString());

        /* Prueba de métodos set y get */
        Libreria.imprime("Prueba de los métodos set y get para cambiar y visualizar atributos de la meta 1");
        meta1.setEstimatedTime(2023, 8, 20);
        Libreria.imprime("Nueva fecha de meta1: " + formatoEsMX.format(meta1.getEstimatedTime()));
        meta1.setState(true);
        Libreria.imprime("El estado de la meta1 se cambio a: " + meta1.getState());

        /* Impresión de la meta1 después de usar los métodos set y get */
        Libreria.imprime("\nInformación de la meta1 usando toString:");
        Libreria.imprime(meta1.toString());

        /* Prueba método equals */
        Libreria.imprime("Prueba del método equals para comparar las metas 1 y 2");
        Libreria.imprime("Las metas 1 y 2 son iguales?");
        Libreria.imprime((meta1.equals(meta2))? "Si" : "No");
        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaTraining(){
        /* Prueba de la clase Training */
        /* Objetos necesarios para probar esta clase */
        /* Creación del formato para las fechas manejadas */
        SimpleDateFormat formatoEsMX = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("ES", "MX"));
        /* Meta ganar masa muscular */
        Goal meta1T = new Goal(0);
        /* Meta bajar de peso */
        Goal meta2T = new Goal(1);
        /* Meta mantener peso */
        Goal meta3T = new Goal(2);
        /* Meta default */
        Goal metaDefT = new Goal();

        Excercises ejerc1T = new Excercises("Pesas", 5, 10, "Banco", 3, "Peso de 5Kg");
        Excercises ejerc2T = new Excercises("Press de pecho", 5, 10, "Banco", 3, "Peso de 5Kg");
        Excercises ejerc3T = new Excercises("Press de pierna", 5, 10, "Banco", 3, "Peso de 5Kg");
        Excercises ejerc4T = new Excercises("Press de tricep", 5, 10, "Banco", 3, "Peso de 5Kg");
        Excercises ejerc15T = new Excercises("Mancuernas", 5, 10, "Banco", 3, "Peso de 5Kg");

        User user3 = new User("Javier","abc123@mail.com",23,"12as3",1.78,76,'M');
        /* Prueba de constructores */
        Libreria.imprime("\t\t\t***** Prueba de la clase Training *****");
        Training planDefault = new Training();  // Constructor por default
        Excercises [] arrPlan1 = new Excercises[5];  // Arreglo usado para el contructor con parámetros
        arrPlan1[0] = ejerc1T;
        arrPlan1[1] = ejerc2T;
        arrPlan1[2] = ejerc3T;
        arrPlan1[3] = ejerc4T;
        arrPlan1[4] = ejerc15T;
        Training plan1 = new Training(meta1T, 5, arrPlan1, user3);  // Constructor con parámetros
        /* Prueba del método toString */
        Libreria.imprime("Información del plan creado a partir del constructor sin parámetros (plan default):");
        Libreria.imprime(planDefault.toString("Sin usuario"));
        Libreria.imprime("Información del plan creado a partir del constructor con parámetros (plan1):");
        Libreria.imprime(plan1.toString(user3.getUserName()));

        /* Prueba de métodos set y get */
        Libreria.imprime("En este punto se utilizarán los métodos set y get para cambiar los atributos del plan default.");
        planDefault.setGoal(meta2T);
        planDefault.setTimePerDay((float)8.9);
        planDefault.setBurnedCalories(5000);
        planDefault.setExcercise(ejerc1T,0);
        planDefault.setExcercise(ejerc2T,1);
        planDefault.setExcercise(ejerc3T,2);
        planDefault.setExcercise(ejerc4T,3);
        planDefault.setExcercise(ejerc15T,4);

        /* Impresión de la información del plan default a través de
           los métodos get */
        Libreria.imprime("Nueva información del plan default obtenida a través de los métodos get: ");
        Libreria.imprime("La meta del plan default es: " + planDefault.getGoal());
        Libreria.imprime("La fecha para cumplir este plan es: " + formatoEsMX.format(planDefault.getDate()));
        Libreria.imprime("El tiempo que se le dedica a este plan al dia son: " + planDefault.getTimePerDay() + " hrs.");
        Libreria.imprime("Las calorias que se queman con este plan son: " + planDefault.getBurnedCalories());
        Libreria.imprime("Los ejercicios que conforman este plan son: ");
        for (int i = 0; i < planDefault.getExcercises().length ;i++ ) {
            Libreria.imprime(planDefault.getExcercises(i) + "");  // Se añade una cadena vacia para que se realice una conversión a String
        }

        /* Prueba del método equals de la clase Training */
        Libreria.imprime("Pruebas del método equals, se comparan los planes plan default y plan1:");
        Libreria.imprime("Los planes de entrenamiento default y 1 son iguales (En este punto no son iguales)?");
        Libreria.imprime((planDefault.equals(plan1))? "Si" : "No");

        /* Modificación de los planes para que ambos sean iguales */
        Libreria.imprime("Modificación de los datos de plan1 para que coincida con plan default");
        plan1.setGoal(meta2T);
        plan1.setTimePerDay((float)8.9);
        plan1.setBurnedCalories(5000);
        plan1.setExcercise(ejerc1T,0);
        plan1.setExcercise(ejerc2T,1);
        plan1.setExcercise(ejerc3T,2);
        plan1.setExcercise(ejerc4T,3);
        plan1.setExcercise(ejerc15T,4);

        Libreria.imprime("Los planes de entrenamiento default y 1 son iguales (En este punto ya son iguales)?");
        Libreria.imprime((planDefault.equals(plan1))? "Si" : "No");
        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaDietGoal(){
    	DietGoal metaAlimento1 = new DietGoal();
        DietGoal metaAlimento2 = new DietGoal();
        metaAlimento1.countDietGoals("pastel");
        metaAlimento1.countDietGoals("pastel");
        metaAlimento1.countDietGoals("pastel");
        metaAlimento2.setFoodName("aguacate");
        metaAlimento2.setState(false);


        Libreria.imprime("**********   Metas Alimenticias   **********");
        Libreria.imprime(metaAlimento1.countDietGoals("pastel"));
        Libreria.imprime(metaAlimento2.toString());
        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaFood(){
    	Food alimento1 = new Food();
        Food alimento2 = new Food();
        alimento1.setFoodName("manzana");
        alimento1.setQuantity("1/2 taza");
        alimento1.setCaloriesPerSlice(123.4);
        alimento1.setType(4);
        alimento1.setGroup(5);
        Libreria.imprime("**********   Alimentos   **********");
        Libreria.imprime(alimento1.toString());
        Libreria.capturaTexto("Presiona enter...");
    }
    public static void pruebaFoodPlan(){
    	FoodPlan planAl = new FoodPlan();
    	FoodPlan planA2 = new FoodPlan();
    	FoodPlan planA3 = new FoodPlan();
    	Libreria.imprime("Método toString del plan de alimentación 1: ");
    	Libreria.imprime(planAl.toString());
    	Libreria.imprime("Cambio en los atributos del plan por medio de los métodos set:");
    	planAl.setConsumedCalories(1000);
    	planAl.setCaloriesPerDay(2000);
    	Libreria.imprime("Impresión de los datos modificados a través de los metodos get:");
    	Libreria.imprime("Las calorias consumidas son: " + planAl.getConsumedCalories());
    	Libreria.imprime("Las calorias al dia son: " + planAl.getCaloriesPerDay());
    	Libreria.imprime("Los planes 1 y 2 son iguales?" + (planAl.equals(planA2)));
    	Libreria.imprime("Los planes 3 y 2 son iguales?" + (planA3.equals(planA2)));
    	Libreria.capturaTexto("Presiona enter...");
    }

}
