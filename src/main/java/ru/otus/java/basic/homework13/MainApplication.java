package ru.otus.java.basic.homework13;

import ru.otus.java.basic.homework13.interfaces.Landscape;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Forest;
import ru.otus.java.basic.homework13.landscape.Plain;
import ru.otus.java.basic.homework13.landscape.Swamp;
import ru.otus.java.basic.homework13.transport.AllTerrainVehicle;
import ru.otus.java.basic.homework13.transport.Bicycle;
import ru.otus.java.basic.homework13.transport.Car;
import ru.otus.java.basic.homework13.transport.Horse;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("====== Домашняя работа по лекции №13 ======");
        System.out.println("===========================================");
        Transport[] vehicles = {
                new Car("Машина Нива", 300),
                new Horse("Лошадь Пегас", 250),
                new AllTerrainVehicle("Вездеход Урал", 1000),
                new Bicycle("Велосипед Заря")
        };

        Landscape[] trace = {
                new Forest(50),
                new Plain(50),
                new Forest(50),
                new Plain(50),
                new Swamp(50),
                new Plain(50)
        };

        Human man = new Human("Иван", 100);
        boolean successTravel = true;

        System.out.println("\n========Доступный транспорт========");
        for (Transport vehicle : vehicles) {
            vehicle.getInfo();
        }

        System.out.println("\n========Путешественник=============");
        man.getInfo();

        System.out.println("\n=============Трасса================");
        for (Landscape land : trace) {
            land.getInfo();
        }

        System.out.println("\n========Прохождение трассы=============");
        for (Landscape landscape : trace) {
            landscape.getInfo();
            // Попытка пройти локацию на транспорте
            for (Transport vehicle : vehicles) {
                if (!vehicle.isActive()) continue;
                if (man.getCurrentTransport() == null) {
                    man.enterTransport(vehicle);
                }
                successTravel = landscape.move(man);
                if (successTravel) break;
                man.outTransport();
            }
            // Если транспортом не получилось пройти - идем пешком.
            if (!successTravel) {
                successTravel = landscape.move(man);
            }
            if (!successTravel) break;
        }

        System.out.println("\n=============ИТОГИ=====================");
        if (successTravel) {
            System.out.println(man.getName() + " преодолел трассу.");
        } else {
            System.out.println(man.getName() + " не смог преодолеть трассу.");
        }

        System.out.println("\n----------состояние транспорта---------");
        for (Transport vehicle : vehicles) {
            vehicle.getInfo();
        }

        System.out.println("\n---------состояние путешественника-----");
        man.getInfo();
    }
}
