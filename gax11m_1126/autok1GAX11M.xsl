<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="autok">
		<xsl:for-each select="auto">
			<xsl:sort select="ar"/>
			<xsl:value-of select="auto[@rsz]"/>
			<xsl:value-of select="ar"/>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>