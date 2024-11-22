package ru.otus.java.basic.homework13;

import ru.otus.java.basic.homework13.interfaces.Landscape;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Location;
import ru.otus.java.basic.homework13.landscape.Territory;
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
                new Car("Машина Нива", 200),
                new Horse("Лошадь Пегас", 100),
                new AllTerrainVehicle("Вездеход Урал", 300),
                new Bicycle("Велосипед Заря")
        };

        Territory[] trace = {
                new Territory(Location.DENSE_FOREST, 100),
                new Territory(Location.SWAMP, 50),
                new Territory(Location.PLAIN, 50),
                new Territory(Location.DENSE_FOREST, 10),
                new Territory(Location.FILLING_STANTION, 0),
                new Territory(Location.DENSE_FOREST, 150),
                new Territory(Location.ROADSIDE_HOTEL, 0),
                new Territory(Location.PLAIN, 100),
                new Territory(Location.SWAMP, 50),
                new Territory(Location.PLAIN, 150),
                new Territory(Location.DENSE_FOREST, 50),
                new Territory(Location.PLAIN, 150),
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
        for (Territory land : trace) {
            land.getInfo();
        }

        System.out.println("\n========Прохождение трассы=============");
        for (Territory landscape : trace) {
            landscape.getInfo();
            // Попытка пройти локацию на транспорте
            for (Transport vehicle : vehicles) {
                if (!vehicle.isActive()) {
                    if (man.getCurrentTransport() == vehicle) {
                        man.outTransport();
                    }
                    continue;
                }
                if (man.getCurrentTransport() == null) {
                    man.enterTransport(vehicle);
                }
                successTravel = landscape.crossing(landscape.getLength(), man);
                if (successTravel) break;
                man.outTransport();
            }
            if (!successTravel) {
                successTravel = landscape.crossing(landscape.getLength(), man);
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
