<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarveiculo" action="VeiculoCadastrar" method="POST">
    
    <table align="center" border="0">
        
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastros de Veiculos
                </th>
            </tr> 
            <tr>
                <th colspan="2" aling="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idveiculo" id="idveiculo" value="${veiculo.idVeiculo}" readonly="readonly"/> </td>
            </tr>
            <tr>
                <td>Marca: </td>
                <td>
                <select name="idmarca" id="idmarca">
                    <option value="">selecione</option>
                    <c:forEach var="marca" items="${marcas}">
                        <option value="${marca.idMarca}" ${veiculo.marca.idMarca == marca.idMarca ? "selected" : ""} > ${marca.descricao} </option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td>Modelo: </td>
                <td>
                <select name="idmodelo" id="idmodelo">
                    <option value="">selecione</option>
                    <c:forEach var="modelo" items="${modelos}">
                        <option value="${modelo.idModelo}" ${veiculo.modelo.idModelo == modelo.idModelo ? "selected" : ""} > ${modelo.descricao} </option>
                    </c:forEach>
                </select>
                </td>
            </tr>
      
            
            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="cadastrar"/>
                    <input type="reset" name="limpar" id="limpar" value="limpar" />
                </td> 
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp"> Voltar à Pagina Principal</a></h5></td>
            </tr>
        </tbody>
    </table>    
</form>
<%@ include file="/footer.jsp" %>
