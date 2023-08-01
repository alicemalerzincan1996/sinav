package com.cemal.utility;

import com.cemal.repository.entity.Sehir;
import com.cemal.service.SehirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
@RequiredArgsConstructor
public class started {
    private final SehirService sehirService;

    @PostConstruct
    public void sehiryukle(){
        Map<String, Integer> cityPopulationMap = new HashMap<>();
        cityPopulationMap.put("İstanbul", 15519267);
        cityPopulationMap.put("Ankara", 5639076);
        cityPopulationMap.put("İzmir", 4320519);
        cityPopulationMap.put("Bursa", 3061096);
        cityPopulationMap.put("Antalya", 2364396);
        cityPopulationMap.put("Adana", 2220125);
        cityPopulationMap.put("Konya", 2304444);
        cityPopulationMap.put("Gaziantep", 2065751);
        cityPopulationMap.put("Eskişehir", 887493);
        cityPopulationMap.put("Diyarbakır", 1780048);

        Map<String, String> cityRegionMap = new HashMap<>();
        cityRegionMap.put("İstanbul", "Marmara");
        cityRegionMap.put("Ankara", "İç Anadolu");
        cityRegionMap.put("İzmir", "Ege");
        cityRegionMap.put("Bursa", "Marmara");
        cityRegionMap.put("Antalya", "Akdeniz");
        cityRegionMap.put("Adana", "Akdeniz");
        cityRegionMap.put("Konya", "İç Anadolu");
        cityRegionMap.put("Gaziantep", "Güneydoğu Anadolu");
        cityRegionMap.put("Eskişehir", "İç Anadolu");
        cityRegionMap.put("Diyarbakır", "Güneydoğu Anadolu");


        Map<String, String> cityDescriptionMap = new HashMap<>();
        cityDescriptionMap.put("İstanbul", " Avrupa ve Asya kıtaları üzerinde yer alan eşsiz bir şehirdir.");
        cityDescriptionMap.put("Ankara", " Türkiye'nin başkentidir ve İç Anadolu Bölgesi'nde yer alır.");
        cityDescriptionMap.put("İzmir", " Ege Bölgesi'nde yer alır ve turistik güzellikleri ile ünlüdür.");
        cityDescriptionMap.put("Bursa", " Marmara Bölgesi'nde yer alan tarihi ve doğal güzellikleri ile bilinir.");
        cityDescriptionMap.put("Antalya", " Akdeniz Bölgesi'nde yer alan tatil cennetidir.");
        cityDescriptionMap.put("Adana", " Akdeniz Bölgesi'nde yer alır ve tarım ve sanayi ile önemli bir şehirdir.");
        cityDescriptionMap.put("Konya", " İç Anadolu Bölgesi'nde yer alır ve tarihi ve kültürel zenginliklere sahiptir.");
        cityDescriptionMap.put("Gaziantep", " Güneydoğu Anadolu Bölgesi'nde yer alır ve gastronomi şehri olarak ünlüdür.");
        cityDescriptionMap.put("Eskişehir", " İç Anadolu Bölgesi'nde yer alır ve üniversiteleriyle bilinir.");
        cityDescriptionMap.put("Diyarbakır", " Güneydoğu Anadolu Bölgesi'nde yer alır ve tarihi Sur ilçesi ile ünlüdür.");


        Map<String, String> cityDescriptionMap2 = new HashMap<>();
        cityDescriptionMap2.put("İstanbul", " En kalabalık sehridir.");
        cityDescriptionMap2.put("Ankara", " Anıtkabirburdadir.");
        cityDescriptionMap2.put("İzmir", " En aydın sehirdir.");
        cityDescriptionMap2.put("Bursa", " Uludag burdadır.");
        cityDescriptionMap2.put("Antalya", " Sıcaktır ve Ruslar buraya gelmek ister.");
        cityDescriptionMap2.put("Adana", " Yemekleri cok iyidir ozelikle kebap.");
        cityDescriptionMap2.put("Konya", " En buyuk ilidir boyutolarak.");
        cityDescriptionMap2.put("Gaziantep", " Baklava diyince akla ilk buragelir.");
        cityDescriptionMap2.put("Eskişehir", " Genc nufus vardır.");
        cityDescriptionMap2.put("Diyarbakır", " Buranında yemekleri guzeldir.");

        List<String> turkishCities = new ArrayList<>(cityPopulationMap.keySet());
        List<Integer> cityPopulations = new ArrayList<>(cityPopulationMap.values());
        List<String> cityRegions = new ArrayList<>(cityRegionMap.values());
        List<String> cityDescriton = new ArrayList<>(cityDescriptionMap.values());
        List<String> cityDescriton2 = new ArrayList<>(cityDescriptionMap2.values());
        ArrayList<Sehir>sehirler=new ArrayList<>();
        for (int i = 0; i < turkishCities.size(); i++) {
            Sehir sehir=Sehir.builder().name(turkishCities.get(i))
                    .Bolge(cityRegions.get(i)).ozelikler(List.of(cityDescriton.get(i),cityDescriton2.get(i))).nufus(cityPopulations.get(i)).build();
            sehirler.add(sehir);



        }
        if (!(sehirService.findAll().size() >=10))

        sehirService.saveAll(sehirler);

    }
}
