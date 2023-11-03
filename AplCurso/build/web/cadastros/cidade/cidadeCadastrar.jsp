<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarcidade" action="CidadeCadastrar" method="POST">
    
    <table align="center" border="0">
        
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastros de Cidades
                </th>
            </tr> 
            <tr>
                <th colspan="2" aling="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idcidade" id="idcidade" value="${cidade.idCidade}" readonly="readonly"/> </td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td><input type="text" name="nomecidade" id="nomecidade" value="${cidade.nomeCidade}" size="50" maxlength="50" /></td>
            </tr>
            <tr>
                <td>Estado: </td>
                <td>
                <select name="idestado" id="idestado">
                    <option value="">selecione</option>
                    <c:forEach var="estado" items="${estados}">
                        <option value="${estado.idEstado}" ${cidade.estado.idEstado == estado.idEstado ? "selected" : ""} > ${estado.nomeEstado} </option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr><td>
                    <input type="hidden" name="situacao" id="situacao" value="${cidade.situacao}" readonly="readonly" />
            </tr></td>
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
