package com.cemal.service;

import com.cemal.dto.request.Tahmin;
import com.cemal.exception.EerrorType;
import com.cemal.exception.TahminerviceException;

import com.cemal.manager.ISehirManager;
import com.cemal.manager.IUserManager;
import com.cemal.rabbitmq.model.Usermodel;
import com.cemal.rabbitmq.producer.CreateUserProducer;
import com.cemal.repository.ITahminRepository;
import com.cemal.repository.entity.Sehir;
import com.cemal.utility.JwtTokenManager;
import com.cemal.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Service
public class TahminService extends ServiceManager<com.cemal.repository.entity.Tahmin,Long> implements Serializable {
   private final ITahminRepository tahminRepository;
    private final ISehirManager iSehirManager;

    private final IUserManager iUserManager;

   private final JwtTokenManager jwtTokenManager;

   private Sehir tahminsehir;

   private Integer point;
   private Integer totalpoint;;

   private Integer oyunsayisi;
   private Boolean cevaplandımı;

   private Long id;

   private  final CreateUserProducer createUserProducer;

    public TahminService(ITahminRepository tahminRepository, ISehirManager iSehirManager, IUserManager iUserManager, JwtTokenManager jwtTokenManager, CreateUserProducer createUserProducer) {
        super(tahminRepository);
        this.tahminRepository = tahminRepository;
        this.iSehirManager = iSehirManager;
        this.iUserManager = iUserManager;
        this.jwtTokenManager = jwtTokenManager;
        this.createUserProducer = createUserProducer;
        tahminsehir=null;
        totalpoint=0;
        oyunsayisi=0;
        cevaplandımı=false;
        id=0L;

    }


    public ResponseEntity<String> random() {
        List<Sehir> sehirlist=sehirleriyuklerame();
        Random rand=new Random();
        tahminsehir=sehirlist.get(rand.nextInt(sehirlist.size()));

        if (id == 0L) return ResponseEntity.ok("Lutfen oyun kurunuz");

        if (oyunsayisi==0) return ResponseEntity.ok("total puanınız"+ totalpoint+" yeni oyuna baslayınız.");
        oyunsayisi=oyunsayisi-1;
        cevaplandımı=false;

        switch (rand.nextInt(3) + 1) {
            case 1:
                return ResponseEntity.ok("bu bolgededir: "+tahminsehir.getBolge());


            case 2:
                return ResponseEntity.ok("nufus: "+tahminsehir.getNufus().toString());
            case 3:
                return ResponseEntity.ok(tahminsehir.getOzelikler().get(rand.nextInt(2)));

        }


        return null;
    }




    public ResponseEntity<String> tahminoyunu(String tahmin){
        System.out.println(oyunsayisi);
        System.out.println(cevaplandımı);
        System.out.println(tahminsehir);
        if (id == null) return ResponseEntity.ok("Lutfen oyun kurunuz");
        System.out.println("id sorun yok");
        if (point==0) return ResponseEntity.ok("5 kere yanlıs bildin resmi yenile");

       // if (oyunsayisi==0) return ResponseEntity.ok("Oyun bitti");
        System.out.println("point yok");

        if(cevaplandımı.equals(true)) return ResponseEntity.ok("Dogru bildni lutfen yenile");
        if (tahmin.equals(tahminsehir.getName()))
        {cevaplandımı=true;
            totalpoint+=point;
            if (oyunsayisi==0){
                Usermodel usermodel =iUserManager.usermodel(id).getBody();
                usermodel.setOynanmasayisi(usermodel.getOynanmasayisi()+1);
                if (usermodel.getMaxskor()<totalpoint) usermodel.setMaxskor(totalpoint);
                createUserProducer.convertAndSend(usermodel);
                iUserManager.update(usermodel);
            }


            return ResponseEntity.ok("Bildiniz"+" "+point+" kazandınız");
        }
        else {
            if (oyunsayisi==0){
                Usermodel usermodel =iUserManager.usermodel(id).getBody();
                usermodel.setOynanmasayisi(usermodel.getOynanmasayisi()+1);
                if (usermodel.getMaxskor()<totalpoint) usermodel.setMaxskor(totalpoint);
                createUserProducer.convertAndSend(usermodel);



            }
            point=point-1;
            return ResponseEntity.ok("bilemediniz");

    }
    }


    public List<Sehir> sehirleriyuklerame(){

        ResponseEntity<List<Sehir>> sehir =iSehirManager.findAll();
        List<Sehir> sehirler=sehir.getBody();
        return sehirler;

    }

    public ResponseEntity<String> oyunubasltamak(String tokken){

        if (!jwtTokenManager.verifyToken(tokken))throw new TahminerviceException(EerrorType.INVALID_TOKEN);
        id=jwtTokenManager.getIdFromToken(tokken).get();
        oyunsayisi=2;
        totalpoint=0;
        point=5;

        return ResponseEntity.ok("Merhaba arkadaslar oyunu baslatbutnuna basrak oyunu baslatalım.\n" +
                         " resim olusturma basıyoruz bize bi ipucu veriyor bunu 2 kere oynuyoruz yapabiliyoruz.\\n" +
                "sonra tahmin oyununa tıklayarak bize verdigi ipucunu tahmin ettimigisi yaziyor. \\n" +
                "eger ilk seferde bilirsek 5 puan 0 a " +
                "kadar gitiyor 0 tahmin etsek bile 0 puan alıyooruz resim olustura birdaha basmamız gerkiyor ." +
                "5.turdan sonra total puanlarımız yukleniyor");


    }




}
