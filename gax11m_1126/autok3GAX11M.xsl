<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="autok">
	<xsl:variable name="counter" as="xs:int" select="0"/>
		<xsl:for-each select="/.">
			<xsl:variable name="counter" select="$counter + 1"/>
		</xsl:for-each>
		<xsl:value-of select="$counter"/>
	</xsl:template>
</xsl:stylesheet>