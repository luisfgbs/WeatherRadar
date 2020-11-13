import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityIdentifiers> firstCall = service.getCityIdentifiers();


        try{
            //call for the identifiers using the function that invokes the proper response from the API (this new method is defined in IpmaService)
            Response<IpmaCityIdentifiers> apiResponse = firstCall.execute();
            IpmaCityIdentifiers identifiers = apiResponse.body();

            if (identifiers != null) {
                List<CityIdentifier> data = identifiers.getData();
                ListIterator<CityIdentifier> dataIterator = data.listIterator();
                while(dataIterator.hasNext()) {
                    CityIdentifier city = dataIterator.next();
                    System.out.println(city.getLocal() + ":" + city.getGlobalIdLocal());
                }
            } else {
                logger.info( "No results!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter CityID");

        int id = scanner.nextInt();  // Read user input

        Call<IpmaCityForecast> callSync = service.getForecastForACity(id);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "max temp for today: " + forecast.getData().
                        listIterator().next().getTMax());
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
