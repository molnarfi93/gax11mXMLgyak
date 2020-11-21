<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="orarend">
		<html>
			<head></head>
			<body>
				<table>
					<td>
						<xsl:for-each select="ora">
							<xsl:if test="idopont[@nap='hétfö']">
								<tr>
									<xsl:value-of select="targy"/>
									<xsl:value-of select="helyszin"/>
									<xsl:value-of select="oktato"/>
									<xsl:value-of select="idopont[@tol]"/>
								</tr>
							</xsl:if>		
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="ora">
							<xsl:if test="idopont[@nap='kedd']">
								<tr>
									<xsl:value-of select="targy"/>
									<xsl:value-of select="helyszin"/>
									<xsl:value-of select="oktato"/>
									<xsl:value-of select="idopont[@tol]"/>
								</tr>
							</xsl:if>		
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="ora">
							<xsl:if test="idopont[@nap='szerda']">
								<tr>
									<xsl:value-of select="targy"/>
									<xsl:value-of select="helyszin"/>
									<xsl:value-of select="oktato"/>
									<xsl:value-of select="idopont[@tol]"/>
								</tr>
							</xsl:if>		
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="ora">
							<xsl:if test="idopont[@nap='csütörtök']">
								<tr>
									<xsl:value-of select="targy"/>
									<xsl:value-of select="helyszin"/>
									<xsl:value-of select="oktato"/>
									<xsl:value-of select="idopont[@tol]"/>
								</tr>
							</xsl:if>		
						</xsl:for-each>
					</td>
				</table>
			</body>	
        </html>
	</xsl:template>
</xsl:stylesheet>