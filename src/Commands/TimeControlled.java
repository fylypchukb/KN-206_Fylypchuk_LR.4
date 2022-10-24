package Commands;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TimeControlled {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future  switchOnTime(LocalDateTime time){
        LocalDateTime curr = LocalDateTime.now();

    }

    public Future switchTimer(Period timer){


    }

    public Future setAsync(LocalDateTime time){
         // todo: запустити асинхроно
    }

}
