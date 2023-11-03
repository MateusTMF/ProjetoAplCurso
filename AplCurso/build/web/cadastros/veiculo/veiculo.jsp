<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Veiculos</h2>
<table id="datatable" class="display"> 
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">Modelo</th>
            <th align="left">Marca</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="veiculo" items="${veiculos}">
            <tr>
                <td align="left">${veiculo.idVeiculo}</td>
                <td aling="left">${veiculo.modelo.descricao}</td>
                <td aling="left">${veiculo.marca.descricao}</td>
                <td align="center">
        <a href=
           "${pageContext.request.contextPath}/VeiculoExcluir?idVeiculo=${veiculo.idVeiculo}">
            Excluir</a></td>
            <td align="center">
                <a href=
                   "${pageContext.request.contextPath}/VeiculoCarregar?idVeiculo=${veiculo.idVeiculo}">
                    Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
    
</table>
    
<div align="center">
    <a href="${pageContext.request.contextPath}/VeiculoNovo">Novo</a>
    <a href="index.jsp">Voltar a pagina Principal</a>
</div>

    <script>
        $(document).ready(function(){
            console.log('entrei ready');
            //caregamos a datatable
            //$("#datatable").DataTable({});
            $('#datatable').DataTable({
                "OLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até_END_de_TOTAL_registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Ultimo"
                    }
                }
            });
        });
    </script>
    
<%@ include file="/footer.jsp" %>


