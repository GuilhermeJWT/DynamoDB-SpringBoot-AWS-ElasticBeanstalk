package br.com.systemsgs.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@DynamoDBDocument
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelEndereco implements Serializable {

    @DynamoDBAttribute
    private String cidade;

    @DynamoDBAttribute
    private String uf;

    @DynamoDBAttribute
    private String cep;

    @DynamoDBAttribute
    private String logradouro;

}
