package br.com.systemsgs.dynamodb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {

    /*Por Seguraça na hora de subir vai ser inserido os dados verdadeiros =)*/
    public static final String SERVICE_ENDPOINT = "dynamodb.ap-us-east-1.amazonaws.com";
    public static String REGION = "ap-us-east-1";
    public static String ACCESS_KEY = "S5EAAADETG334T4T204T43";
    public static final String SECRET_KEY = "I8E145rt177af4weGJPZVH4478E11287TR5";

    public DynamoDBMapper mapper(){
        return new DynamoDBMapper(amazonDynamoDBConfig());
    }

    private AmazonDynamoDB amazonDynamoDBConfig(){
        return AmazonDynamoDBAsyncClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }

}
