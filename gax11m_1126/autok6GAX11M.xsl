<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="autok">
		<xsl:for-each-group select="auto" group-by="tulaj/varos">
			<xsl:element name="varos">
				<xsl:value-of select="current-grouping-key()"/>	
				<xsl:element name="dbszam">
					<xsl:value-of select="count(current-group())"/>
				</xsl:element>
				<xsl:element name="osszar">
					<xsl:value-of select="sum(current-group()/ar)"/>
				</xsl:element>	
			</xsl:element>			
		</xsl:for-each-group>	
	</xsl:template>
</xsl:stylesheet>