package br.com.systemsgs.dynamodb.repository;

import br.com.systemsgs.dynamodb.model.ModelPessoa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PessoaRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public ModelPessoa salvar(ModelPessoa modelPessoa){
        mapper.save(modelPessoa);
        return modelPessoa;
    }

    public ModelPessoa pesquisaPorId(String id){
        return mapper.load(ModelPessoa.class, id);
    }

    public String deletar(ModelPessoa modelPessoa){
        mapper.delete(modelPessoa);
        return "Pessoa Deletada com Sucesso: " + modelPessoa.getNome();
    }

    public String editar(ModelPessoa modelPessoa){
        mapper.save(modelPessoa,buildExpression(modelPessoa));
        return "Pessoa Editada com Sucesso: " + modelPessoa.getNome();
    }

    private DynamoDBSaveExpression buildExpression(ModelPessoa modelPessoa){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("pessoaId", new ExpectedAttributeValue(new AttributeValue().withS(modelPessoa.getId())));
        dynamoDBSaveExpression.setExpected(expectedAttributeValueMap);

        return dynamoDBSaveExpression;
    }

}
