<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="autok">
		<xsl:variable name="num_fiat" as="xs:int" select="0"/>
		<xsl:variable name="num_skoda" as="xs:int" select="0"/>
		<xsl:variable name="num_opel" as="xs:int" select="0"/>
		<xsl:for-each select="auto">
			<xsl:for-each select="auto/tipus">
				<xsl:choose>
					<xsl:when test="text() = 'Fiat'">
						<xsl:variable name="num_fiat" select="$num_fiat + 1"/>
					</xsl:when>
					<xsl:when test="text() = 'Skoda'">
						<xsl:variable name="num_skoda" select="$num_skoda + 1"/>
					</xsl:when>
					<xsl:when test="text() = 'Opel'">
						<xsl:variable name="num_opel" select="$num_opel + 1"/>
					</xsl:when>
				</xsl:choose>
			</xsl:for-each>
		</xsl:for-each>
		<xsl:value-of select="$num_fiat"/>
		<xsl:value-of select="$num_skoda"/>
		<xsl:value-of select="$num_opel"/>
	</xsl:template>
</xsl:stylesheet>